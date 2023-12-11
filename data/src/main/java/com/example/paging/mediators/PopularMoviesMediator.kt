package com.example.paging.mediators

import Mappers.toMovie
import androidx.paging.*
import androidx.paging.LoadState.Loading.endOfPaginationReached
import androidx.room.withTransaction
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.db.MovieDatabase
import com.example.domain.repository.RemoteMoviesRepository
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PopularMoviesMediator @Inject constructor(
    private val db: MovieDatabase,
    private val repository: RemoteMoviesRepository
) : RemoteMediator<Int, Movie>() {

    override suspend fun initialize(): InitializeAction {
        val cachedTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - (db.getRemoteKeysDao().getCreationTime()
                ?: 0) < cachedTimeout
        ) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }


    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
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
            val apiResponse = repository.getPopularMovies(page = page)
            val movies = apiResponse.data?.results?.map { movieDto ->
                movieDto.toMovie()
            }


            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.getRemoteKeysDao().clearRemoteKeys()
                    db.getMovieDao().clearAllMovies()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = movies?.map { movie ->
                    MovieRemoteKeys(
                        movieID = movie.id,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }
                remoteKeys?.let {
                    db.getRemoteKeysDao().insertAllKeys(remoteKeys)
                }
                movies?.let { movieList ->
                    db.getMovieDao()
                        .insertPopularMovies(movieList.onEachIndexed { _, movie -> movie.page = page })
                }

            }
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (error: IOException) {
            return MediatorResult.Error(error)
        } catch (error: HttpException) {
            return MediatorResult.Error(error)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, Movie>): MovieRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                db.getRemoteKeysDao().getRemoteKeyByMovieID(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Movie>): MovieRemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { movie ->
            db.getRemoteKeysDao().getRemoteKeyByMovieID(movie.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Movie>): MovieRemoteKeys? {
        return state.pages.lastOrNull() {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { movie ->
            db.getRemoteKeysDao().getRemoteKeyByMovieID(movie.id)
        }
    }
}
