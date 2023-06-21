package com.example.cinemaxv3.presentation.ui.viewmodels.TopRatedTvShowsViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.domain.use_cases.toprated_TVshows_usecase.TopRatedTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedTvShowsViewModel @Inject constructor(
    private val getTopRatedTvShowsUseCase: TopRatedTvShowsUseCase
) : ViewModel() {

    private val _topRatedTvShowsUiState = MutableStateFlow(TopRatedTvShowsUiState())
    val topRatedTvShowsUiState: StateFlow<TopRatedTvShowsUiState> = _topRatedTvShowsUiState

    fun getTopRatedTvShows(): Flow<PagingData<TvShowsResults>> = getTopRatedTvShowsUseCase().cachedIn(viewModelScope)
//        viewModelScope.launch {
//            try {
//                _topRatedTvShowsUiState.value = TopRatedTvShowsUiState(isLoading = true)
//                val topRatedTvShows = getTopRatedTvShowsUseCase()
//                _topRatedTvShowsUiState.value = _topRatedTvShowsUiState.value.copy(topRatedTvShowsFlow = topRatedTvShows)
//
//            } catch (e: Exception) {
//                _topRatedTvShowsUiState.value = TopRatedTvShowsUiState(
//                    isLoading = false,
//                    error(message = e.message ?: "An unexpected error")
//                )
//            }
//        }

    }
