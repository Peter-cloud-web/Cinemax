package com.example.cinemaxv3.viewmodels.movieCastViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.example.domain.use_cases.moviecasts_usecase.MovieCastsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MovieCastsViewModel @Inject constructor(
    private val getMovieCastsUseCase: MovieCastsUseCase
) : ViewModel() {

    private val _movieCastsResponse = MutableStateFlow(MovieCastsUiStates())
    val movieCastResponse = _movieCastsResponse.asStateFlow()

    fun movieCasts(id: Int) {
        try {
            viewModelScope.launch {
                _movieCastsResponse.value = MovieCastsUiStates(isLoading = true)
                val response = getMovieCastsUseCase(id).data?.cast?.asFlow()
                _movieCastsResponse.value = MovieCastsUiStates(movieCasts = response!!)
            }
        } catch (e: Exception) {
            _movieCastsResponse.value =
                MovieCastsUiStates(error = handleMovieCastsErrors(e))
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