package com.example.data.paging.pagingSource.popular_TVshows_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.MovieRepository
import com.example.data.paging.pagingSource.PopularTvShowsPagingSource
import com.example.framework.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularTvShowsUseCase @Inject constructor(private val repository: com.example.domain.MovieRepository) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<TvShowsResults>> {
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