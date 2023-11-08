package com.example.domain.use_cases.popular_TVshows_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.pager.PopularTvShowsPager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularTvShowsUseCase @Inject constructor(private val popularTvShowsPager: PopularTvShowsPager) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<TvShowsResults>> {
        val popularTvShowsPager = popularTvShowsPager.getPopularTvShows()
        return popularTvShowsPager
    }
}