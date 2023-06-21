package com.example.cinemaxv3.domain.use_cases.moviecasts_usecase

import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.domain.model.movieCasts.Cast
import com.example.cinemaxv3.domain.model.movieCasts.MovieCastsResponse
import com.example.cinemaxv3.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieCastsUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int) = repository.getMovieCasts(id = id)
}