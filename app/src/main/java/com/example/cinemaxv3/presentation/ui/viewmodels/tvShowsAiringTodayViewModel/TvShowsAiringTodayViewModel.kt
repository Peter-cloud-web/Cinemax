package com.example.cinemaxv3.presentation.ui.viewmodels.tvShowsAiringTodayViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.domain.use_cases.TVshows_airingToday_usecase.TvShowsAringTodayUseCase
import com.example.cinemaxv3.domain.use_cases.TVshows_ontheair_usecase.TvShowsOnTheAirUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TvShowsAiringTodayViewModel @Inject constructor(private val tvShowsAiringTodayUseCase: TvShowsAringTodayUseCase) : ViewModel(){
    fun getTvShowsAiringToday(): Flow<PagingData<TvShowsResults>> = tvShowsAiringTodayUseCase().cachedIn(viewModelScope)
}