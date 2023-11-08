package com.example.domain.use_cases.insert_favouritemovies_usecase

import com.example.domain.repository.MovieRepository
import com.example.domain.entities.model.favourites.FavouriteMovies
import javax.inject.Inject

class InsertFavouriteMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(favouriteMovies: FavouriteMovies) {
        repository.insertFavouriteMovies(favouriteMovies)
    }
}