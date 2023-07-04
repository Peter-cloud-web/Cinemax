package com.example.domain.use_cases.popular_TVshows_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.framework.repository.MovieRepository
import com.example.paging.pagingSource.PopularTvShowsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularTvShowsUseCase @Inject constructor(private val repository: com.example.framework.repository.MovieRepository) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<com.example.framework.model.tvShowsResponse.TvShowsResults>> {
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