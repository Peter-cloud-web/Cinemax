package com.example.cinemaxv3.domain.use_cases.favouritemovies_usecase

import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<FavouriteMovies>> = repository.getFavouriteMovies()
}