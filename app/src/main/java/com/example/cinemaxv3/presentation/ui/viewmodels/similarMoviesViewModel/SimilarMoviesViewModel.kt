package com.example.cinemaxv3.presentation.ui.viewmodels.similarMoviesViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.similarmovies_usecase.SimilarMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SimilarMoviesViewModel @Inject constructor(private val similarMovieUseCase: SimilarMovieUseCase) :
    ViewModel() {

    private val _similarMovies = MutableStateFlow(SimilarMoviesUiState())
    val similarMovies = _similarMovies.asStateFlow()

    init {
        val id: Int? = null
        if (id != null) {
            getSimilarMovies(id = id)
        }
    }

    fun getSimilarMovies(id: Int) {
        try {
            viewModelScope.launch {
                _similarMovies.value = SimilarMoviesUiState(isLoading = true)
                val response = similarMovieUseCase(id).data
                _similarMovies.value = SimilarMoviesUiState(similarMovies = response)
            }
        } catch (e: Exception) {
            _similarMovies.value =
                SimilarMoviesUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            _similarMovies.value = SimilarMoviesUiState(
                error = e.localizedMessage
                    ?: "Experiencing Network/Internet issues. Try again later"
            )
        }
    }

}