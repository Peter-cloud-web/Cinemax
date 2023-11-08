package com.example.cinemaxv3.viewmodels.movieCastViewModel

import com.example.domain.entities.model.movieCasts.Cast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieCastsUiStates(
    val isLoading: Boolean = false,
    val movieCasts: Flow<Cast> = emptyFlow(),
    val error: String = ""

)