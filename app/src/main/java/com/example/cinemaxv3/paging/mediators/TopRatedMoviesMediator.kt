package com.example.cinemaxv3.paging.mediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.cinemaxv3.data.remote.mappers.Mappers.toTopRatedMovie
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.TopRatedRemoteKeys
import com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class TopRatedMoviesMediator(
    private val api:MovieApi,
    private val db:MovieDatabase
) :RemoteMediator<Int,TopRatedMovies>(){

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
            val apiResponse = api.getTopRatedMovies(page = page)
            val topRatedMovies = apiResponse.movies.map {
                it.toTopRatedMovie()
            }
            val endOfPaginationReached = topRatedMovies.isEmpty()

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.getTopRatedMoviesDao().clearAllTopRatedMovies()
                    db.getTopRatedRemoteKeysDao().clearTopRatedRemoteKeys()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = topRatedMovies.map{
                    TopRatedRemoteKeys(
                        movieID = it.id,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }
                db.getTopRatedRemoteKeysDao().insertAllTopRatedKeys(remoteKeys)
                db.getTopRatedMoviesDao().insertTopRatedMovies(topRatedMovies.onEachIndexed { _, movie->
                        movie.page = page
                    })
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