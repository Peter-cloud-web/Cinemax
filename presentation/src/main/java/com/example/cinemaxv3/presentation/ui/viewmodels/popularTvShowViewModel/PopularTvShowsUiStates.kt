package com.example.cinemaxv3.presentation.ui.viewmodels.popularTvShowViewModel

import androidx.paging.PagingData
import com.example.framework.model.tvShowsResponse.TvShowsResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PopularTvShowsUiStates(
    val isLoading: Boolean = false,
    val popularTvShows: Flow<PagingData<TvShowsResults>> = emptyFlow(),
    val error: String = ""
)