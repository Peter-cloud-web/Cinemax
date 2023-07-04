package com.example.domain.use_cases.TVshows_airingToday_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.framework.model.tvShowsResponse.TvShowsResults
import com.example.framework.repository.MovieRepository
import com.example.paging.pagingSource.TvShowsAiringTodayPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsAringTodayUseCase @Inject constructor(private val repository: com.example.framework.repository.MovieRepository) {

    operator fun invoke(): Flow<PagingData<com.example.framework.model.tvShowsResponse.TvShowsResults>> {
        @OptIn(ExperimentalPagingApi::class)
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