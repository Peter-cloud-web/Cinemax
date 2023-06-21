package com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel

import androidx.paging.PagingData
import com.example.cinemaxv3.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PopularMoviesUiState(
    val isLoading: Boolean = false,
    val popularMovies: Flow<PagingData<Movie>> = emptyFlow(),
    val error: String = ""
)
