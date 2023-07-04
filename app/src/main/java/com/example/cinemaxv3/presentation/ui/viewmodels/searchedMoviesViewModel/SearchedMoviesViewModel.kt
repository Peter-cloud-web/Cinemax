package com.example.cinemaxv3.presentation.ui.viewmodels.searchedMoviesViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.framework.movieDto.MovieResponseDto
import com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase
import com.example.service.MovieApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchedMoviesViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase,
    private val api: MovieApi
) : ViewModel() {

    private val _searchMoviesResponse = MutableLiveData<com.example.framework.movieDto.MovieResponseDto?>()
    val SearchResponse: LiveData<com.example.framework.movieDto.MovieResponseDto?> = _searchMoviesResponse
//        get() = _searchMoviesResponse

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = searchMoviesUseCase(query = query)
            _searchMoviesResponse.value = response.data
        }
    }
}