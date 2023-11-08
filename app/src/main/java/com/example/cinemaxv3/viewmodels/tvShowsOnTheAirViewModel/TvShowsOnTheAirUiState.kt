package com.example.cinemaxv3.viewmodels.tvShowsOnTheAirViewModel

import androidx.paging.PagingData
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class TvShowsOnTheAirUiState(
    val isLoading: Boolean = false,
    val tvShowsOnTheAir: Flow<PagingData<TvShowsResults>> = emptyFlow(),
    val error: String = ""
)