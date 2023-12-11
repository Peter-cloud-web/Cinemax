package com.example.domain.use_cases.insert_favouritemovies_usecase

import com.example.domain.repository.RemoteMoviesRepository
import com.example.domain.entities.model.favourites.FavouriteMovies
import com.example.domain.repository.CachedMoviesRepository
import javax.inject.Inject

class InsertFavouriteMoviesUseCase @Inject constructor(private val repository: CachedMoviesRepository) {
    suspend operator fun invoke(favouriteMovies: FavouriteMovies) {
        repository.insertFavouriteMovies(favouriteMovies)
    }
}