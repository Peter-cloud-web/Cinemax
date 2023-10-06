package com.example.domain.use_cases.favouritemovies_usecase


import com.example.framework.model.favourites.FavouriteMovies
import com.example.framework.repository.MovieRepository
import javax.inject.Inject

class InsertFavouriteMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(favouriteMovies: FavouriteMovies) {
        repository.insertFavouriteMovies(favouriteMovies)
    }
}