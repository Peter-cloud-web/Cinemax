package com.example.cinemaxv3.repository


import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.models.favourites.FavouriteMovies
import javax.inject.Inject


class Repository @Inject constructor(
    private val db: MovieDatabase
) {
    fun getFavouriteMovies() = db.getFavouriteMoviesDao().getAllFavouriteMovies()

    suspend fun insertFavouriteMovies(favouriteMovies: FavouriteMovies) {
        db.getFavouriteMoviesDao().insertFavouriteMovies(favouriteMovies)
    }
}