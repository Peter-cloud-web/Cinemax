package com.example.domain.use_cases.toprated_TVshows_usecase

import androidx.paging.PagingData
import com.example.domain.pager.ToPRatedTvShowsPager
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedTvShowsUseCase @Inject constructor(private val toPRatedTvShowsPager: ToPRatedTvShowsPager) {
    operator fun invoke(): Flow<PagingData<TvShowsResults>> {
        val tvShows = toPRatedTvShowsPager.getTopRatedTvShows()
        return tvShows
    }

}