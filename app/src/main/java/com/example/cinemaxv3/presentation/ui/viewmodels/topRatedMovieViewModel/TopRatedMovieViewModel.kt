package com.example.cinemaxv3.presentation.ui.viewmodels.topRatedMovieViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.cinemaxv3.domain.use_cases.top_rated_movies_usecase.TopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TopRatedMovieViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: TopRatedMoviesUseCase
) : ViewModel() {

    private val _topRatedMovieStates = MutableStateFlow(TopRatedMovieUiState())
    val topRatedMovieUiState = _topRatedMovieStates.asStateFlow()

    init {
        getTopRatedMovies()
    }

    fun getTopRatedMovies() {
        try {
            _topRatedMovieStates.value = TopRatedMovieUiState(isLoading = true)
            val pagingData = getTopRatedMoviesUseCase().cachedIn(viewModelScope)
            _topRatedMovieStates.value = TopRatedMovieUiState(topRatedMovies = pagingData)
        } catch (e: Exception) {
            _topRatedMovieStates.value =
                TopRatedMovieUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            _topRatedMovieStates.value =
                TopRatedMovieUiState(error = "Network error, check internet connection and try again")
        }
    }


}
