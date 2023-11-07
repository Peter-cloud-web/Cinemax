package com.example.cinemaxv3.presentation.ui.viewmodels.movieReviewsViewModel

import androidx.lifecycle.MutableLiveData
import com.example.cinemaxv3.models.responses.Review

data class MovieReviewsUiStates(
    val isLoading: Boolean = false,
    val isSuccess: MutableLiveData<List<Review>?>? = null,
    val isError:String = ""

)