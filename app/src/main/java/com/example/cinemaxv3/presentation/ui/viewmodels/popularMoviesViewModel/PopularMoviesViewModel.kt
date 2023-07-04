package com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel

import Mappers.toMovie
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.cinemaxv3.models.Movie
import com.example.domain.use_cases.popularMovies_usecase.PopularMoviesUseCase
import com.example.framework.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: PopularMoviesUseCase,
    private val repository: MovieRepository
) : ViewModel() {

    private val _popularMovieStates = MutableStateFlow(PopularMoviesUiState())
    val popularMoviesUiState = _popularMovieStates.asStateFlow()

    suspend fun getTopRatedMovie(): List<Movie>? =
        repository.getPopularMovies(1).data?.results?.map {
            it.toMovie()
        }

    init {
        getPopularMovies()
    }

    fun getPopularMovies() {
        try {
            _popularMovieStates.value = PopularMoviesUiState(isLoading = true)
            val pagingData = getPopularMoviesUseCase().cachedIn(viewModelScope)
            _popularMovieStates.value = PopularMoviesUiState(popularMovies = pagingData)
        } catch (e: Exception) {
            _popularMovieStates.value =
                PopularMoviesUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            _popularMovieStates.value =
                PopularMoviesUiState(error = "Network error, check internet connection and try again")
        }

    }

}




