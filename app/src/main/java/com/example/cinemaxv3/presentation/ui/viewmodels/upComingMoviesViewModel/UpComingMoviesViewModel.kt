package com.example.cinemaxv3.presentation.ui.viewmodels.upComingMoviesViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
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

    private val _upComingMoviesState = MutableStateFlow(UpComingMoviesUiState())
    val upComingMoviesState = _upComingMoviesState.asStateFlow()

    init {
        getUpComingMovies()
    }

    fun getUpComingMovies() {
        try {
            _upComingMoviesState.value = UpComingMoviesUiState(isLoading = true)
            val response = getUpComingMoviesUseCase().cachedIn(viewModelScope)
            _upComingMoviesState.value = UpComingMoviesUiState(upComingMovies = response)
        } catch (e: Exception) {
            _upComingMoviesState.value =
                UpComingMoviesUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            _upComingMoviesState.value =
                UpComingMoviesUiState(error = "Network error, check internet connection and try again")
        }
    }
}