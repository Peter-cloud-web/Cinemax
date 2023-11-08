package com.example.domain.use_cases.TVshows_airingToday_usecase

import androidx.paging.PagingData
import com.example.domain.pager.TvShowsAiringTodayPager
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsAringTodayUseCase @Inject constructor(private val tvShowsAiringTodayPager: TvShowsAiringTodayPager) {

    operator fun invoke(): Flow<PagingData<TvShowsResults>> {
        val tvShowsAiringTodayPager = tvShowsAiringTodayPager.getTvSowsAiringToday()
        return tvShowsAiringTodayPager
    }
}