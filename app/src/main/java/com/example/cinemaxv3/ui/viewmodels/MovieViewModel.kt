package com.example.cinemaxv3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.paging.pager.PopularMoviesPager
import com.example.cinemaxv3.paging.pager.TopRatedMoviesPager
import com.example.cinemaxv3.paging.pager.UpComingMoviesPager
import com.example.cinemaxv3.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: Repository,
    private val popularMoviesPager: PopularMoviesPager,
    private val topRatedMoviesPager: TopRatedMoviesPager,
    private val upComingMoviesPager: UpComingMoviesPager
) : ViewModel() {

    val topRatedMovies = repository.topRatedMovieListData.cachedIn(viewModelScope)
    val upComingMovies = repository.upComingMovieListData.cachedIn(viewModelScope)

    @OptIn(ExperimentalPagingApi::class)
    fun getPopularMovies(): Flow<PagingData<Movie>> = popularMoviesPager.pager
    @JvmName("getTopRatedMovies1")
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> = topRatedMoviesPager.pager
    @JvmName("getUpComingMovies1")
    fun getUpComingMovies():Flow<PagingData<UpComingMovies>> = upComingMoviesPager.pager

}

