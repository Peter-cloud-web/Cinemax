package com.example.cinemaxv3.viewmodels.TopRatedTvShowsViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bumptech.glide.load.HttpException
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.use_cases.toprated_TVshows_usecase.TopRatedTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TopRatedTvShowsViewModel @Inject constructor(
    private val getTopRatedTvShowsUseCase: TopRatedTvShowsUseCase
) : ViewModel() {

    private val _topRatedTvShowsUiState = MutableStateFlow(UiStates<TvShowsResults>())
    val topRatedTvShowsUiState = _topRatedTvShowsUiState.asStateFlow()


    init {
        getTopRatedTvShows()
    }

    fun getTopRatedTvShows() {
        try {
            _topRatedTvShowsUiState.value = UiStates(isLoading = true)
            val response = getTopRatedTvShowsUseCase().cachedIn(viewModelScope)
            _topRatedTvShowsUiState.value = UiStates(movies = response)
        } catch (e: Exception) {
            _topRatedTvShowsUiState.value =
                UiStates(error = handleToRatedTvShowsErrors(e))
        }
    }

    private fun handleToRatedTvShowsErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }

}
