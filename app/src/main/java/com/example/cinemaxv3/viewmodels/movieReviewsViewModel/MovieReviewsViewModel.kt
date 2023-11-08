package com.example.cinemaxv3.viewmodels.movieReviewsViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.example.domain.use_cases.movieReviews_usecase.MovieReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieReviewsViewModel @Inject constructor(private val movieReviewUseCase: MovieReviewUseCase) :
    ViewModel() {
    private val _movieReviews = MutableStateFlow(MovieReviewsUiStates())
    val movieReviews  = _movieReviews.asStateFlow()
    fun getReviews(id: Int){
        try {
            viewModelScope.launch {
                _movieReviews.value = MovieReviewsUiStates(isLoading = true)
                val response = movieReviewUseCase(id).data?.review?.asFlow()
                _movieReviews.value = MovieReviewsUiStates(reviews = response!!)
            }

        }catch (e:Exception){
            _movieReviews.value = MovieReviewsUiStates(error = handleMovieCastsErrors(e))
        }
    }
    private fun handleMovieCastsErrors(e:Exception):String{
        return  when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred. Check API connection"
            else -> "An unexpected error occurred"
        }
    }

}