package com.example.cinemaxv3.presentation.ui.viewmodels.TopRatedTvShowsViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
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

    private val _topRatedTvShowsUiState = MutableStateFlow(TopRatedTvShowsUiState())
    val topRatedTvShowsUiState = _topRatedTvShowsUiState.asStateFlow()


    init {
        getTopRatedTvShows()
    }

    fun getTopRatedTvShows() {
        try {
            _topRatedTvShowsUiState.value = TopRatedTvShowsUiState(isLoading = true)
            val response = getTopRatedTvShowsUseCase().cachedIn(viewModelScope)
            _topRatedTvShowsUiState.value = TopRatedTvShowsUiState(topRatedTvShowsFlow = response)
        } catch (e: Exception) {
            _topRatedTvShowsUiState.value =
                TopRatedTvShowsUiState(error = e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            _topRatedTvShowsUiState.value = TopRatedTvShowsUiState(
                error = e.localizedMessage ?: "Underlying Network/Internet server error occurred"
            )
        }
    }


}
