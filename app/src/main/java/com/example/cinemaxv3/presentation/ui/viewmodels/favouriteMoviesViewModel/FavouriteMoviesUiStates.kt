package com.example.cinemaxv3.presentation.ui.viewmodels.favouriteMoviesViewModel

import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.domain.model.movieCasts.MovieCastsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class FavouriteMoviesUiStates(
    val isLoading: Boolean = false,
    val favouriteMovies: Flow<List<FavouriteMovies>> = emptyFlow(),
    val error: String = ""
)

