package com.example.cinemaxv3.viewmodels.tvShowsOnTheAirViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bumptech.glide.load.HttpException
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.use_cases.TVshows_ontheair_usecase.TvShowsOnTheAirUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TvShowsOnTheAirViewModel @Inject constructor(private val tvShowsOnTheAirUseCase: TvShowsOnTheAirUseCase) :
    ViewModel() {

    private val _tvShowsOnTheAir = MutableStateFlow(UiStates<TvShowsResults>())
    val tvShowsOnTheAir = _tvShowsOnTheAir.asStateFlow()

    init {
        getTvShowsOnTheAir()
    }

    fun getTvShowsOnTheAir() {
        try {
            _tvShowsOnTheAir.value = UiStates(isLoading = true)
            val response = tvShowsOnTheAirUseCase().cachedIn(viewModelScope)
            _tvShowsOnTheAir.value = UiStates(movies = response)
        } catch (e: Exception) {
            _tvShowsOnTheAir.value =
                UiStates(error = handleTvShowsOnTheAirErrors(e))
        }
    }

    private fun handleTvShowsOnTheAirErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }
}