package com.example.cinemaxv3.domain.use_cases.popular_TVshows_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.domain.paging.pagingSource.PopularTvShowsPagingSource
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class PopularTvShowsUseCase @Inject constructor(private val repository: MovieRepository) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke() : Flow<PagingData<TvShowsResults>>{
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