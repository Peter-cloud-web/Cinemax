package com.example.cinemaxv3.paging.mediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys
import com.example.cinemaxv3.models.responses.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class TopRatedTvShowsMediator(private val api: MovieApi, private val db: MovieDatabase) :
    RemoteMediator<Int, TvShowsResults>() {

    override suspend fun initialize(): InitializeAction {
        val cacheTimeOut = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - (db.getTopRatedTvShowsRemoteKeysDao()
                .getTopRatedTvShowsRemoteKeysCreaionTime() ?: 0) < cacheTimeOut
        ) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TvShowsResults>
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
            val apiResponse = api.getTopRatedTvShows(page = page)
            val topRatedTvShows = apiResponse.results
            val endOfPaginationReached = topRatedTvShows.isEmpty()

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.getTopRatedTvShowsDao().clearAllMovies()
                    db.getTopRatedTvShowsRemoteKeysDao().clearTopRatedTvShowsRemoteKeys()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1
                val remoteKeys = topRatedTvShows.map {
                    TopRatedTvShowsRemoteKeys(
                        movieID = it.id,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }
                db.getTopRatedTvShowsRemoteKeysDao().insertTopRatedTvShowsRemoteKeys(remoteKeys)
                db.getTopRatedTvShowsDao()
                    .insertsTopRatedTvShows(topRatedTvShows.onEachIndexed { _, movie->
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

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, TvShowsResults>): TopRatedTvShowsRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                db.getTopRatedTvShowsRemoteKeysDao().getTopRatedTvShowsRemoteKeysById(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, TvShowsResults>): TopRatedTvShowsRemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { tvShows ->
            db.getTopRatedTvShowsRemoteKeysDao().getTopRatedTvShowsRemoteKeysById(tvShows.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, TvShowsResults>): TopRatedTvShowsRemoteKeys? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { tvShows ->
            db.getTopRatedTvShowsRemoteKeysDao().getTopRatedTvShowsRemoteKeysById(tvShows.id)
        }
    }
}