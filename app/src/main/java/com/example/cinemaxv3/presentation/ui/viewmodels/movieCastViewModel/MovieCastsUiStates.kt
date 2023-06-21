package com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel

import com.example.cinemaxv3.domain.model.movieCasts.Cast
import com.example.cinemaxv3.domain.model.movieCasts.MovieCastsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.toList

data class MovieCastsUiStates(
    val isLoading: Boolean = false,
    val movieCasts: MovieCastsResponse? = null,
    val error: String = ""

)