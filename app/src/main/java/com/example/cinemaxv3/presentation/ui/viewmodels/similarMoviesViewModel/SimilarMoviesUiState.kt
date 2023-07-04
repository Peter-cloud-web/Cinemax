package com.example.cinemaxv3.presentation.ui.viewmodels.similarMoviesViewModel

import com.example.framework.model.similarMoviesResponse.SimilarMoviesResponse


data class SimilarMoviesUiState(
    val isLoading: Boolean = false,
    val similarMovies: SimilarMoviesResponse? = null,
    val error:String = ""

)