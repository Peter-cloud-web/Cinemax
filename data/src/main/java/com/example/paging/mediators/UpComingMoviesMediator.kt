package com.example.paging.mediators

import Mappers.toUpComingMovies
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState.Loading.endOfPaginationReached
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.models.UpComingRemoteKeys
import com.example.db.MovieDatabase
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class UpComingMoviesMediator @Inject constructor(
    private val db: MovieDatabase,
    private val repository: RemoteMoviesRepository
) : RemoteMediator<Int, UpComingMovies>() {
    override suspend fun initialize(): InitializeAction {
        val cachedTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - (db.getUpComingRemoteKeysDao()
                .getUpComingCreationTime() ?: 0) < cachedTimeout
        ) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UpComingMovies>
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
            val apiResponse = repository.getUpComingMovies(page = page)
            val upComingMovies = apiResponse.data?.movies?.map { upComingMoviesDto ->
                upComingMoviesDto.toUpComingMovies()
            }

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.getUpComingRemoteKeysDao().clearUpComingRemoteKeys()
                    db.getUpComingMoviesDao().getUpComingMovies()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = upComingMovies?.map { upComingMovies ->
                    UpComingRemoteKeys(
                        movieID = upComingMovies.id,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }

                if (remoteKeys != null) {
                    db.getUpComingRemoteKeysDao().insertAllUpComingKeys(remoteKeys)
                }
                if (upComingMovies != null) {
                    db.getUpComingMoviesDao()
                        .insertUpComingMovies(upComingMovies.onEachIndexed { _, upComingMovies ->
                            upComingMovies.page = page
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

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, UpComingMovies>): UpComingRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                db.getUpComingRemoteKeysDao().getUpComingRemoteKeyByMovieID(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, UpComingMovies>): UpComingRemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { movie ->
            db.getUpComingRemoteKeysDao().getUpComingRemoteKeyByMovieID(movie.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, UpComingMovies>): UpComingRemoteKeys? {
        return state.pages.lastOrNull() {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { movie ->
            db.getUpComingRemoteKeysDao().getUpComingRemoteKeyByMovieID(movie.id)
        }
    }
}
