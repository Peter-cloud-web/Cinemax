package com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel

import com.example.entities.model.movieCasts.Cast
import com.example.entities.model.movieCasts.MovieCastsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieCastsUiStates(
    val isLoading: Boolean = false,
    val movieCasts: Flow<Cast> = emptyFlow(),
    val error: String = ""

)