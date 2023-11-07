package com.example.cinemaxv3.presentation.ui.viewmodels.movieReviewsViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.example.domain.use_cases.movieReviews_usecase.MovieReviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieReviewsViewModel @Inject constructor(private val movieReviewUseCase: MovieReviewUseCase) :
    ViewModel() {
    private val _movieReviews = MutableLiveData<MovieReviewsUiStates>()
    val movieReviews: LiveData<MovieReviewsUiStates>
        get() = _movieReviews

    fun getReviews(id: Int) {
        try {
            viewModelScope.launch {
                _movieReviews.postValue(MovieReviewsUiStates(isLoading = true))
                val response = movieReviewUseCase(id)

                if (response != null && response.data?.review != null) {

                    _movieReviews.postValue(
                        MovieReviewsUiStates(
                            isSuccess = MutableLiveData(
                                response.data?.review
                            )
                        )
                    )
                } else {
                    _movieReviews.postValue(MovieReviewsUiStates(isError = "No reviews available"))
                }
            }
        } catch (e: Exception) {
            _movieReviews.postValue(MovieReviewsUiStates(isError = handleMovieCastsErrors(e)))
        }
    }

    private fun handleMovieCastsErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred. Check API connection"
            else -> "An unexpected error occurred"
        }
    }

}