package com.example.cinemaxv3.viewmodels.tvShowsAiringTodayViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bumptech.glide.load.HttpException
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.use_cases.TVshows_airingToday_usecase.TvShowsAringTodayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TvShowsAiringTodayViewModel @Inject constructor(private val tvShowsAiringTodayUseCase: TvShowsAringTodayUseCase) :
    ViewModel() {

    private val _tvShowsAiringTodayUiState = MutableStateFlow(UiStates<TvShowsResults>())
    val tvShowsAiringTodayUiState = _tvShowsAiringTodayUiState.asStateFlow()

    init {
        getTvShowsAiringToday()
    }

    fun getTvShowsAiringToday() {
        try {
            _tvShowsAiringTodayUiState.value = UiStates(isLoading = true)
            val response = tvShowsAiringTodayUseCase().cachedIn(viewModelScope)
            _tvShowsAiringTodayUiState.value =
                UiStates(movies = response)
        } catch (e: Exception) {
            _tvShowsAiringTodayUiState.value = UiStates(
                error = handleTvShowsAiringTodayErrors(e)
            )
        }
    }

    private fun handleTvShowsAiringTodayErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }
}