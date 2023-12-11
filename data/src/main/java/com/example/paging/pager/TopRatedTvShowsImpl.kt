package com.example.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.db.MovieDatabase
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.pager.ToPRatedTvShowsPager
import com.example.domain.repository.RemoteMoviesRepository
import com.example.paging.mediators.TopRatedTvShowsMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedTvShowsImpl @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val repository: RemoteMoviesRepository
) : ToPRatedTvShowsPager {
    override fun getTopRatedTvShows(): Flow<PagingData<TvShowsResults>> {
        @OptIn(ExperimentalPagingApi::class) val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                movieDatabase.getTopRatedTvShowsDao().getTopRatedTvShows()
            }, remoteMediator = TopRatedTvShowsMediator(repository, movieDatabase)
        ).flow
        return pager
    }
}