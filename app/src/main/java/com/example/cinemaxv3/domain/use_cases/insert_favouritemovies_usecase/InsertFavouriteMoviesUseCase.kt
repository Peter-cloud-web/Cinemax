package com.example.cinemaxv3.domain.use_cases.insert_favouritemovies_usecase

import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.domain.repository.MovieRepository
import javax.inject.Inject

class InsertFavouriteMoviesUseCase @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke(favouriteMovies: com.example.cinemaxv3.domain.model.favourites.FavouriteMovies) {
      repository.insertFavouriteMovies(favouriteMovies)
    }
}