package com.example.cinemaxv3.presentation.ui.viewmodels.tvShowsAiringTodayViewModel

import androidx.paging.PagingData
import com.example.framework.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class TvShowsAiringTodayUiState(
    val isLoading: Boolean = false,
    val tvShowsAiringToday: Flow<PagingData<TvShowsResults>> = emptyFlow(),
    val error: String = ""


)