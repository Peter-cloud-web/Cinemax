package com.example.domain.repository

import com.example.domain.entities.model.favourites.FavouriteMovies
import kotlinx.coroutines.flow.Flow

interface CachedMoviesRepository {
    fun getFavouriteMovies(): Flow<List<FavouriteMovies>>?

    suspend fun insertFavouriteMovies(favouriteMovies: FavouriteMovies):Unit?

    suspend fun deleteFavouriteMovie(id: Int):Unit?
}