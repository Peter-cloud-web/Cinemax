package com.example.cinemaxv3.viewmodels.similarMoviesViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.example.domain.use_cases.similarmovies_usecase.SimilarMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SimilarMoviesViewModel @Inject constructor(private val similarMovieUseCase: SimilarMovieUseCase) :
    ViewModel() {

    private val _similarMovies = MutableStateFlow(SimilarMoviesUiState())
    val similarMovies = _similarMovies.asStateFlow()

    fun getSimilarMovies(id: Int) {
        try {
            viewModelScope.launch {
                _similarMovies.value = SimilarMoviesUiState(isLoading = true)
                val response = similarMovieUseCase(id).data?.results?.asFlow()
                _similarMovies.value = SimilarMoviesUiState(similarMovies = response!!)
            }
        } catch (e: Exception) {
            _similarMovies.value =
                SimilarMoviesUiState(error = handleSearchMoviesErrors(e))
        }
    }
    private fun handleSearchMoviesErrors(e:Exception):String{
        return  when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }

}