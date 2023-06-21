package com.example.cinemaxv3.domain.use_cases.movieReviews_usecase

import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.models.responses.ReviewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieReviewUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int) = repository.getMovieReviews(id)
}