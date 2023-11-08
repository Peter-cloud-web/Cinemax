package com.example.domain.use_cases.favouritemovies_usecase

import com.example.domain.repository.MovieRepository
import com.example.domain.entities.model.favourites.FavouriteMovies
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<FavouriteMovies>> =
        repository.getFavouriteMovies()
}