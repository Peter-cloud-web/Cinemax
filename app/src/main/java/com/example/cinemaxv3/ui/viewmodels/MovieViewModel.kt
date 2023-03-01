package com.example.cinemaxv3.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.paging.pager.PopularMoviesPager
import com.example.cinemaxv3.paging.pager.TopRatedMoviesPager
import com.example.cinemaxv3.paging.pager.UpComingMoviesPager
import com.example.cinemaxv3.service.MovieApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import org.koin.android.BuildConfig
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    val api: MovieApi,
    val popularMoviesPager: PopularMoviesPager,
    val topRatedMoviesPager: TopRatedMoviesPager,
    val upComingMoviesPager: UpComingMoviesPager
) : ViewModel() {
    @OptIn(ExperimentalPagingApi::class)
    fun getPopularMovies(): Flow<PagingData<Movie>> = popularMoviesPager.pager

    @JvmName("getTopRatedMovies1")
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> = topRatedMoviesPager.pager

    @JvmName("getUpComingMovies1")
    fun getUpComingMovies(): Flow<PagingData<UpComingMovies>> = upComingMoviesPager.pager

    fun getReviews( id:Int) = liveData(Dispatchers.IO){
        val reviews = api.getMovieReviews(id)
        emit(reviews)
    }
}