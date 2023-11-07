package com.example.domain.use_cases.TVshows_ontheair_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging.pagingSource.TvShowsOnTheAirPagingSource
import com.example.domain.repository.MovieRepository
import com.example.entities.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsOnTheAirUseCase @Inject constructor(private val repository: MovieRepository) {

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
                com.example.paging.pagingSource.TvShowsOnTheAirPagingSource(repository = repository)
            },
        ).flow
        return pager
    }
}