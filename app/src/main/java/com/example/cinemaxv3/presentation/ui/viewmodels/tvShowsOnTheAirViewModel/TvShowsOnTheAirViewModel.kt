package com.example.cinemaxv3.presentation.ui.viewmodels.tvShowsOnTheAirViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.domain.use_cases.TVshows_ontheair_usecase.TvShowsOnTheAirUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TvShowsOnTheAirViewModel @Inject constructor(private val tvShowsOnTheAirUseCase: TvShowsOnTheAirUseCase): ViewModel(){
    fun getTvShowsOnTheAir(): Flow<PagingData<TvShowsResults>> = tvShowsOnTheAirUseCase().cachedIn(viewModelScope)
}