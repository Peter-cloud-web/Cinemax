package com.example.cinemaxv3.presentation.ui.viewmodels.tvShowsOnTheAirViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.domain.use_cases.TVshows_ontheair_usecase.TvShowsOnTheAirUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TvShowsOnTheAirViewModel @Inject constructor(private val tvShowsOnTheAirUseCase: TvShowsOnTheAirUseCase) :
    ViewModel() {

    private val _tvShowsOnTheAir = MutableStateFlow(TvShowsOnTheAirUiState())
    val tvShowsOnTheAir = _tvShowsOnTheAir.asStateFlow()

    init {
        getTvShowsOnTheAir()
    }

    fun getTvShowsOnTheAir() {
        try {
            _tvShowsOnTheAir.value = TvShowsOnTheAirUiState(isLoading = true)
            val response = tvShowsOnTheAirUseCase().cachedIn(viewModelScope)
            _tvShowsOnTheAir.value = TvShowsOnTheAirUiState(tvShowsOnTheAir = response)
        } catch (e: Exception) {
            _tvShowsOnTheAir.value =
                TvShowsOnTheAirUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            _tvShowsOnTheAir.value = TvShowsOnTheAirUiState(
                error = e.localizedMessage ?: "Underlying Network/Internet server error occurred"
            )
        }
    }
}