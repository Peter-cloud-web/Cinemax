package com.example.domain.use_cases.favouritemovies_usecase

import com.example.framework.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<com.example.framework.model.favourites.FavouriteMovies>> =
        repository.getFavouriteMovies()
}