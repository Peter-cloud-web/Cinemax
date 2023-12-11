package com.example.paging.pager

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.pager.TvShowsAiringTodayPager
import com.example.domain.repository.RemoteMoviesRepository
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.paging.pagingSource.TvShowsAiringTodayPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsAiringTodayImpl @Inject constructor(private val repository: RemoteMoviesRepository):TvShowsAiringTodayPager {
    override fun getTvSowsAiringToday(): Flow<PagingData<TvShowsResults>> {
        val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                TvShowsAiringTodayPagingSource(repository = repository)
            },
        ).flow
        return pager
    }
}