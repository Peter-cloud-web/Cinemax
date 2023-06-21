package com.example.cinemaxv3.presentation.ui.viewmodels.movieReviewsViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemaxv3.domain.use_cases.movieReviews_usecase.MovieReviewUseCase
import com.example.cinemaxv3.models.responses.Review
import com.example.cinemaxv3.models.responses.ReviewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieReviewsViewModel @Inject constructor(private val movieReviewUseCase: MovieReviewUseCase) : ViewModel(){
    fun getReviews(id:Int):Flow<ReviewsResponse?> = flow{
            val response = movieReviewUseCase(id)
            emit(response.data)
        }
}