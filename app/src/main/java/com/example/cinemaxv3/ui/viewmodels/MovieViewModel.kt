package com.example.cinemaxv3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.models.responses.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.paging.pager.PopularMoviesPager
import com.example.cinemaxv3.paging.pager.TopRatedMoviesPager
import com.example.cinemaxv3.paging.pager.TopRatedTvShowsPager
import com.example.cinemaxv3.paging.pager.UpComingMoviesPager
import com.example.cinemaxv3.repository.Repository
import com.example.cinemaxv3.service.MovieApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    val api: MovieApi,
    val repository: Repository,
    val popularMoviesPager: PopularMoviesPager,
    val topRatedMoviesPager: TopRatedMoviesPager,
    val upComingMoviesPager: UpComingMoviesPager,
    val topRatedTvShowsPager: TopRatedTvShowsPager
) : ViewModel() {
    @OptIn(ExperimentalPagingApi::class)
    fun getPopularMovies(): Flow<PagingData<Movie>> = popularMoviesPager.pager.cachedIn(viewModelScope)
    @JvmName("getTopRatedMovies1")
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> = topRatedMoviesPager.pager.cachedIn(viewModelScope)

    @JvmName("getUpComingMovies1")
    fun getUpComingMovies(): Flow<PagingData<UpComingMovies>> = upComingMoviesPager.pager .cachedIn(viewModelScope)

    @JvmName("getTopRatedTvShows")
    fun getTopRatedTvShows():Flow<PagingData<TvShowsResults>> = topRatedTvShowsPager.pager .cachedIn(viewModelScope)

    fun getReviews( id:Int) = liveData(Dispatchers.IO){
        val reviews = api.getMovieReviews(id)
        emit(reviews)
    }

    fun getCastMembers(id: Int) = liveData(Dispatchers.IO){
        val casts = api.getMovieCasts(id)
        emit(casts)
    }

    fun getMovieTrailer(id:Int) = liveData(Dispatchers.IO){
       val url =  api.getMovieTrailer(id)
        emit(url)
    }
    fun getSimilarMovies(id:Int) = liveData(Dispatchers.IO){
        val similarMovies = api.getSimilarMovies(id)
        emit(similarMovies)
    }

    }
