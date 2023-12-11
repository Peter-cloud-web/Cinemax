package com.example.domain.use_cases.favouritemovies_usecase

import com.example.domain.repository.RemoteMoviesRepository
import com.example.domain.entities.model.favourites.FavouriteMovies
import com.example.domain.repository.CachedMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteMovieUseCase @Inject constructor(private val repository: CachedMoviesRepository) {
    operator fun invoke(): Flow<List<FavouriteMovies>>? =
        repository.getFavouriteMovies()
}