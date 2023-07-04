package com.example.domain.use_cases.similarmovies_usecase

import com.example.framework.repository.MovieRepository
import javax.inject.Inject

class SimilarMovieUseCase @Inject constructor(private val repository: com.example.framework.repository.MovieRepository) {

    suspend operator fun invoke(id: Int) = repository.getSimilarMovies(id = id)

}