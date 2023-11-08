package com.example.cinemaxv3.viewmodels.popularTvShowViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bumptech.glide.load.HttpException
import com.example.cinemaxv3.viewmodels.popularMoviesViewModel.UiStates
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults
import com.example.domain.use_cases.popular_TVshows_usecase.PopularTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PopularTvShowViewModel @Inject constructor(
    private val getPopularTvShowsUseCase: PopularTvShowsUseCase,
) : ViewModel() {

    private val _popularTvShowState = MutableStateFlow(UiStates<TvShowsResults>()) //Mutable
    val popularTvShowsUiStates = _popularTvShowState.asStateFlow() //immutable

    init {
        getPopularTvShows()
    }

    fun getPopularTvShows() {
        try {
            _popularTvShowState.value = UiStates(isLoading = true)
            val response = getPopularTvShowsUseCase().cachedIn(viewModelScope)
            _popularTvShowState.value = UiStates(movies = response)
        } catch (e: Exception) {
            _popularTvShowState.value =
                UiStates(error = handlePopularTvShowsErrors(e))
        }
    }

    private fun handlePopularTvShowsErrors(e: Exception): String {
        return when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }


}