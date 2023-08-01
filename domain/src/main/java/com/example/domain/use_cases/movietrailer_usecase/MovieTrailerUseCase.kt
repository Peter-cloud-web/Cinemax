package com.example.domain.use_cases.movietrailer_usecase

import com.example.framework.repository.MovieRepository
import javax.inject.Inject

class MovieTrailerUseCase @Inject constructor(private val repository: com.example.framework.repository.MovieRepository) {
    suspend operator fun invoke(id: Int) =
        repository.getMovieTrailers(id = id)
}