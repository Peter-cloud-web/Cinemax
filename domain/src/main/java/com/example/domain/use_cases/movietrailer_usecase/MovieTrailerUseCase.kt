package com.example.domain.use_cases.movietrailer_usecase

import com.example.domain.repository.RemoteMoviesRepository
import javax.inject.Inject

class MovieTrailerUseCase @Inject constructor(private val repository: RemoteMoviesRepository) {
    suspend operator fun invoke(id: Int) = repository.getMovieTrailers(id = id)
}