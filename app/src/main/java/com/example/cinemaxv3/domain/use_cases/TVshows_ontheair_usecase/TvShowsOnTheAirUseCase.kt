package com.example.cinemaxv3.domain.use_cases.TVshows_ontheair_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.domain.paging.pagingSource.TvShowsOnTheAirPagingSource
import com.example.cinemaxv3.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class TvShowsOnTheAirUseCase @Inject constructor(private val repository: MovieRepository) {

    operator fun invoke():Flow<PagingData<TvShowsResults>> {
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