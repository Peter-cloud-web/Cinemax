package com.example.cinemaxv3.domain.use_cases.similarmovies_usecase

import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.domain.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.cinemaxv3.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class SimilarMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int) = repository.getSimilarMovies(id = id)

}