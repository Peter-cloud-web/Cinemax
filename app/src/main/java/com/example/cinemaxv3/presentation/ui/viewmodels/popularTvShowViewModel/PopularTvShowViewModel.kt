package com.example.cinemaxv3.presentation.ui.viewmodels.popularTvShowViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.domain.use_cases.popular_TVshows_usecase.PopularTvShowsUseCase
import com.example.cinemaxv3.presentation.ui.viewmodels.TopRatedTvShowsViewModel.TopRatedTvShowsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PopularTvShowViewModel @Inject constructor(
    private val getPopularTvShowsUseCase: PopularTvShowsUseCase,
) : ViewModel() {

    private val _popularTvShowState = MutableStateFlow(PopularTvShowsUiStates()) //Mutable
    val popularTvShowsUiStates = _popularTvShowState.asStateFlow() //immutable

    init {
        getPopularTvShows()
    }
    fun getPopularTvShows(){
        try{
            _popularTvShowState.value  =  PopularTvShowsUiStates(isLoading = true)
            val response = getPopularTvShowsUseCase().cachedIn(viewModelScope)
            _popularTvShowState.value = PopularTvShowsUiStates(popularTvShows = response )
        }catch (e:Exception){
            _popularTvShowState.value = PopularTvShowsUiStates(error = e.localizedMessage?:"An unexpected error occurred")
        }catch (e: IOException){
            _popularTvShowState.value = PopularTvShowsUiStates(error = e.localizedMessage?:"Underlying Network/Internet server error occurred")
        }
    }



}