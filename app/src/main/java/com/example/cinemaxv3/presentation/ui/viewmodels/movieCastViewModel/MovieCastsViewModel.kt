package com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.moviecasts_usecase.MovieCastsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieCastsViewModel @Inject constructor(
    private val getMovieCastsUseCase: MovieCastsUseCase
) : ViewModel() {

    private val _movieCastsResponse = MutableStateFlow(MovieCastsUiStates())
    val movieCastResponse = _movieCastsResponse.asStateFlow()

    init {
        val id: Int? = null
        if (id != null) {
            movieCasts(id = id)
        }
    }

    fun movieCasts(id: Int) {
        try {
            viewModelScope.launch {
                _movieCastsResponse.value = MovieCastsUiStates(isLoading = true)
                val response = getMovieCastsUseCase(id).data
                _movieCastsResponse.value = MovieCastsUiStates(movieCasts = response)
            }
        } catch (e: Exception) {
            _movieCastsResponse.value =
                MovieCastsUiStates(error = e.localizedMessage ?: "An unexpected error occurred")
        }
    }

}