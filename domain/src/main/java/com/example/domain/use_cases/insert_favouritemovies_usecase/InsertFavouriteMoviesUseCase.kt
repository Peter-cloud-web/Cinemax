package com.example.domain.use_cases.insert_favouritemovies_usecase

import com.example.framework.repository.MovieRepository
import javax.inject.Inject

class InsertFavouriteMoviesUseCase @Inject constructor(private val repository: com.example.framework.repository.MovieRepository) {
    suspend operator fun invoke(favouriteMovies: com.example.framework.model.favourites.FavouriteMovies) {
        repository.insertFavouriteMovies(favouriteMovies)
    }
}