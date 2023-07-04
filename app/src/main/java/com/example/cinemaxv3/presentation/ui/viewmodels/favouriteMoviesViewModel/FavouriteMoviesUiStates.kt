package com.example.cinemaxv3.presentation.ui.viewmodels.favouriteMoviesViewModel

import com.example.framework.model.favourites.FavouriteMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class FavouriteMoviesUiStates(
    val isLoading: Boolean = false,
    val favouriteMovies: Flow<List<FavouriteMovies>> = emptyFlow(),
    val error: String = ""
)

