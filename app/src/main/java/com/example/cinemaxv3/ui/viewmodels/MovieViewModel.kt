package com.example.cinemaxv3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.paging.MoviePagingSource
import com.example.cinemaxv3.repository.Repository
import com.example.cinemaxv3.service.MovieApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor (private val apiService: MovieApi ) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)){
        MoviePagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}

