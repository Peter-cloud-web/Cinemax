package com.example.cinemaxv3.viewmodels.topRatedMovieViewModel

import androidx.paging.PagingData
import com.example.cinemaxv3.models.TopRatedMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class TopRatedMovieUiState(
    val isLoading: Boolean = false,
    val topRatedMovies: Flow<PagingData<TopRatedMovies>> = emptyFlow(),
    val error: String = ""
)