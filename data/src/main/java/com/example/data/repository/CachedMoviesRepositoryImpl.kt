package com.example.data.repository

import com.example.db.MovieDatabase
import com.example.domain.entities.model.favourites.FavouriteMovies
import com.example.domain.repository.CachedMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CachedMoviesRepositoryImpl @Inject constructor(
    private val db: MovieDatabase?
) : CachedMoviesRepository {

    override fun getFavouriteMovies(): Flow<List<FavouriteMovies>>? =
        db?.getFavouriteMoviesDao()?.getAllFavouriteMovies()

    override suspend fun insertFavouriteMovies(favouriteMovies: FavouriteMovies) =
        db?.getFavouriteMoviesDao()
            ?.insertFavouriteMovies(favouriteMovies)

    override suspend fun deleteFavouriteMovie(id: Int) = db?.getFavouriteMoviesDao()
        ?.deleteFavouriteMovie(id)
}