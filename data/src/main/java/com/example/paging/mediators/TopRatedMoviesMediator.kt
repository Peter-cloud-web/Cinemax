package com.example.paging.mediators

import Mappers.toTopRatedMovie
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState.Loading.endOfPaginationReached
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.TopRatedRemoteKeys
import com.example.db.MovieDatabase
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class TopRatedMoviesMediator(
    private val db: MovieDatabase,
    private val repository: RemoteMoviesRepository
) : RemoteMediator<Int, TopRatedMovies>() {

    override suspend fun initialize(): InitializeAction {
        val cacheTimeOut = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - (db.getTopRatedRemoteKeysDao()
                .getTopRatedCreationTime() ?: 0) < cacheTimeOut
        ) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TopRatedMovies>
    ): MediatorResult {
        val page: Int = when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: 1
            }

            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                prevKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }

            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                nextKey
                    ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }

        try {
            val apiResponse = repository.getTopRatedMovies(page = page)

            val topRatedMovies = apiResponse.data?.movies?.map { TopRatedMoviesDto ->
                TopRatedMoviesDto.toTopRatedMovie()

            }

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.getTopRatedMoviesDao().clearAllTopRatedMovies()
                    db.getTopRatedRemoteKeysDao().clearTopRatedRemoteKeys()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = topRatedMovies?.map { TopRatedMovies ->
                    TopRatedRemoteKeys(
                        movieID = TopRatedMovies.id,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }
                remoteKeys?.let { remoteKeys ->
                    db.getTopRatedRemoteKeysDao().insertAllTopRatedKeys(remoteKeys)
                }

                topRatedMovies?.let { topRatedMovies ->
                    db.getTopRatedMoviesDao()
                        .insertTopRatedMovies(topRatedMovies.onEachIndexed { _, topRatedMovies ->
                            topRatedMovies.page = page
                        })
                }
            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (error: IOException) {
            return MediatorResult.Error(error)
        } catch (error: HttpException) {
            return MediatorResult.Error(error)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, TopRatedMovies>): TopRatedRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                db.getTopRatedRemoteKeysDao().getTopRatedRemoteKeyByMovieID(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, TopRatedMovies>): TopRatedRemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { movies ->
            db.getTopRatedRemoteKeysDao().getTopRatedRemoteKeyByMovieID(movies.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, TopRatedMovies>): TopRatedRemoteKeys? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { movies ->
            db.getTopRatedRemoteKeysDao().getTopRatedRemoteKeyByMovieID(movies.id)
        }
    }
}