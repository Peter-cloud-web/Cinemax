package com.example.domain.use_cases.movieReviews_usecase

import com.example.domain.repository.RemoteMoviesRepository
import javax.inject.Inject

class MovieReviewUseCase @Inject constructor(private val repository: RemoteMoviesRepository) {
    suspend operator fun invoke(id: Int) = repository.getMovieReviews(id)
}