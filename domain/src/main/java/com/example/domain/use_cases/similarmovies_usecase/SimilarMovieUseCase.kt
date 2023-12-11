package com.example.domain.use_cases.similarmovies_usecase

import com.example.domain.repository.RemoteMoviesRepository
import javax.inject.Inject

class SimilarMovieUseCase @Inject constructor(private val repository: RemoteMoviesRepository) {

    suspend operator fun invoke(id: Int) = repository.getSimilarMovies(id = id, 1)

}