package com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel

import com.example.framework.model.movieCasts.MovieCastsResponse

data class MovieCastsUiStates(
    val isLoading: Boolean = false,
    val movieCasts: com.example.framework.model.movieCasts.MovieCastsResponse? = null,
    val error: String = ""

)