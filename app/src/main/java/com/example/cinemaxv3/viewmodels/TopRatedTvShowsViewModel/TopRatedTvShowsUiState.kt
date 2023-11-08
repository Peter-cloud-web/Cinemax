package com.example.cinemaxv3.viewmodels.TopRatedTvShowsViewModel

import androidx.paging.PagingData
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class TopRatedTvShowsUiState(
    val isLoading: Boolean = false,
    val topRatedTvShowsFlow: Flow<PagingData<TvShowsResults>> = emptyFlow(),
    val error: String = ""
)

