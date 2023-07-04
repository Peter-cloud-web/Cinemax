package com.example.cinemaxv3.presentation.ui.viewmodels.tvShowsAiringTodayViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.use_cases.TVshows_airingToday_usecase.TvShowsAringTodayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TvShowsAiringTodayViewModel @Inject constructor(private val tvShowsAiringTodayUseCase: TvShowsAringTodayUseCase) :
    ViewModel() {

    private val _tvShowsAiringTodayUiState = MutableStateFlow(TvShowsAiringTodayUiState())
    val tvShowsAiringTodayUiState = _tvShowsAiringTodayUiState.asStateFlow()

    init {
        getTvShowsAiringToday()
    }

    fun getTvShowsAiringToday() {
        try {
            _tvShowsAiringTodayUiState.value = TvShowsAiringTodayUiState(isLoading = true)
            val response = tvShowsAiringTodayUseCase().cachedIn(viewModelScope)
            _tvShowsAiringTodayUiState.value =
                TvShowsAiringTodayUiState(tvShowsAiringToday = response)
        } catch (e: Exception) {
            _tvShowsAiringTodayUiState.value = TvShowsAiringTodayUiState(
                error = e.localizedMessage ?: "An unexpected error occurred"
            )
        } catch (e: IOException) {
            _tvShowsAiringTodayUiState.value = TvShowsAiringTodayUiState(
                error = e.localizedMessage ?: "Underlying Network/Internet server error occurred"
            )
        }
    }
}