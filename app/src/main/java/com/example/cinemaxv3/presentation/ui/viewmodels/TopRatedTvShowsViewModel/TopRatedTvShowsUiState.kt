package com.example.cinemaxv3.presentation.ui.viewmodels.TopRatedTvShowsViewModel

import androidx.paging.PagingData
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.replay

data class TopRatedTvShowsUiState(
    val isLoading: Boolean = false,
    val topRatedTvShowsFlow: Flow<PagingData<TvShowsResults>>  = emptyFlow(),
    val error: String = ""
)

