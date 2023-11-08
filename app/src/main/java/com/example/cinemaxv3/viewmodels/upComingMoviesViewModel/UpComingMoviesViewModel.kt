package com.example.cinemaxv3.viewmodels.upComingMoviesViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bumptech.glide.load.HttpException
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates
import com.example.domain.use_cases.upcomingMovies_usecase.UpComingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class UpComingMoviesViewModel @Inject constructor(
    private val getUpComingMoviesUseCase: UpComingMoviesUseCase,

    ) : ViewModel() {

    private val _upComingMoviesState = MutableStateFlow(UiStates<UpComingMovies>())
    val upComingMoviesState = _upComingMoviesState.asStateFlow()

    init {
        getUpComingMovies()
    }

    fun getUpComingMovies() {
        try {
            _upComingMoviesState.value = UiStates(isLoading = true)
            val response = getUpComingMoviesUseCase().cachedIn(viewModelScope)
            _upComingMoviesState.value = UiStates(movies = response)
        } catch (e: Exception) {
            _upComingMoviesState.value =
                UiStates(error = handleUpComingMoviesErrors(e))
        }
    }

    private fun handleUpComingMoviesErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }
}