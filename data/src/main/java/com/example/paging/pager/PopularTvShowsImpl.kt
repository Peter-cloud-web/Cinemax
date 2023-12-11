package com.example.paging.pager

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.pager.PopularTvShowsPager
import com.example.domain.repository.RemoteMoviesRepository
import com.example.paging.pagingSource.PopularTvShowsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularTvShowsImpl @Inject constructor(private val repository: RemoteMoviesRepository) :
    PopularTvShowsPager {
    override fun getPopularTvShows(): Flow<PagingData<TvShowsResults>> {
        val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PopularTvShowsPagingSource(repository = repository)
            },
        ).flow

        return pager
    }
}