package com.example.cinemaxv3.presentation.ui.viewmodels.upComingMoviesViewModel

import androidx.paging.PagingData
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.models.UpComingMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class UpComingMoviesUiState(
    val isLoading: Boolean = false,
    val upComingMovies: Flow<PagingData<UpComingMovies>> = emptyFlow(),
    val error: String = ""
)