package com.example.data.paging.pagingSource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.MovieRepository
import com.example.framework.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsOnTheAirUseCase @Inject constructor(private val repository: com.example.domain.MovieRepository) {

    operator fun invoke(): Flow<PagingData<TvShowsResults>> {
        @OptIn(ExperimentalPagingApi::class)
        val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                TvShowsOnTheAirPagingSource(repository = repository)
            },
        ).flow
        return pager
    }
}