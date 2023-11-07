package com.example.domain.use_cases.moviecasts_usecase

import com.example.domain.MovieRepository
import javax.inject.Inject


class MovieCastsUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(id: Int) = repository.getMovieCasts(id = id)
}