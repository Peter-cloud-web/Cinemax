package com.example.cinemaxv3.presentation.ui.viewmodels.movieReviewsViewModel

import androidx.lifecycle.ViewModel
import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.domain.use_cases.movieReviews_usecase.MovieReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MovieReviewsViewModel @Inject constructor(private val movieReviewUseCase: MovieReviewUseCase) :
    ViewModel() {
    fun getReviews(id: Int): Flow<ReviewsResponse?> = flow {
        val response = movieReviewUseCase(id)
        emit(response.data)
    }
}