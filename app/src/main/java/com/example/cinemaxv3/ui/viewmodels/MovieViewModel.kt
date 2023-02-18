package com.example.cinemaxv3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import com.example.cinemaxv3.db.dao.MovieDao
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

//    private val refreshTriggerChannel = Channel<PagingSource.LoadParams.Refresh>()
//    private val refreshTrigger = refreshTriggerChannel

    val popularMovies = repository.popularMovieListData.cachedIn(viewModelScope)
    val topRatedMovies = repository.topRatedMovieListData.cachedIn(viewModelScope)
    val upComingMovies = repository.upComingMovieListData.cachedIn(viewModelScope)


//    val getMovies = refreshTrigger.

    fun saveMovies(movie:List<Movie>) = viewModelScope.launch {
        repository.insertMovie(movie)
    }

}

