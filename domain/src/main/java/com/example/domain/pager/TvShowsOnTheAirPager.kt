package com.example.domain.pager

import androidx.paging.PagingData
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow

interface TvShowsOnTheAirPager {
    fun getTvShowsOnTheAir(): Flow<PagingData<TvShowsResults>>
}