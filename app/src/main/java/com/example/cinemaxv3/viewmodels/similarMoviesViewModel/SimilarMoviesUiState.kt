package com.example.cinemaxv3.viewmodels.similarMoviesViewModel

import com.example.domain.entities.model.similarMoviesResponse.SimilarMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class SimilarMoviesUiState(
    val isLoading: Boolean = false,
    val similarMovies: Flow<SimilarMovies> = emptyFlow(),
    val error:String = ""

)