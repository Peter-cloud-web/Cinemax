package com.example.domain.use_cases.TVshows_ontheair_usecase

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.paging.PagingData
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.pager.TvShowsOnTheAirPager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsOnTheAirUseCase @Inject constructor(private val tvShowsOnTheAirPager: TvShowsOnTheAirPager) {

    operator fun invoke(): Flow<PagingData<TvShowsResults>> {
        val tvShowsOnTheAirPager = tvShowsOnTheAirPager.getTvShowsOnTheAir()
        return tvShowsOnTheAirPager
    }
}