package com.example.domain.use_cases.movieReviews_usecase

import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class MovieReviewUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(id: Int) = repository.getMovieReviews(id)
}