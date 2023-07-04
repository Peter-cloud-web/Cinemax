package com.example.domain.use_cases.moviecasts_usecase

import com.example.framework.repository.MovieRepository
import javax.inject.Inject


class MovieCastsUseCase @Inject constructor(private val repository: com.example.framework.repository.MovieRepository) {

    suspend operator fun invoke(id: Int) = repository.getMovieCasts(id = id)
}