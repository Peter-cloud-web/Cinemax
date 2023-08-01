package com.example.domain.use_cases.movieReviews_usecase

import com.example.framework.repository.MovieRepository
import javax.inject.Inject

class MovieReviewUseCase @Inject constructor(private val repository: com.example.framework.repository.MovieRepository) {
    suspend operator fun invoke(id: Int) = repository.getMovieReviews(id)
}