package com.example.cinemaxv3.ui.viewmodels

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.*
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.models.favourites.FavouriteMovies
import com.example.cinemaxv3.models.responses.moviesResponse.MovieResponse
import com.example.cinemaxv3.models.responses.tvShowsResponse.TvShowsResults
import com.example.cinemaxv3.paging.pager.*
import com.example.cinemaxv3.repository.Repository
import com.example.cinemaxv3.service.MovieApi
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    val api: MovieApi,
    val repository: Repository,
    val popularMoviesPager: PopularMoviesPager,
    val topRatedMoviesPager: TopRatedMoviesPager,
    val upComingMoviesPager: UpComingMoviesPager,
    val topRatedTvShowsPager: TopRatedTvShowsPager,
    val popularTvShowsPager: PopularTvShowsPager,
    val latestTvShowsPager: LatestTvShowsPager,
) : ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    fun getPopularMovies(): Flow<PagingData<Movie>> =
        popularMoviesPager.pager.cachedIn(viewModelScope)

    @JvmName("getTopRatedMovies")
    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> =
        topRatedMoviesPager.pager.cachedIn(viewModelScope)

    @JvmName("getUpComingMovies")
    fun getUpComingMovies(): Flow<PagingData<UpComingMovies>> =
        upComingMoviesPager.pager.cachedIn(viewModelScope)

    @JvmName("getTopRatedTvShows")
    fun getTopRatedTvShows(): Flow<PagingData<TvShowsResults>> =
        topRatedTvShowsPager.pager.cachedIn(viewModelScope)

    @JvmName("getPopularTvShows")
    fun getPopularTvShows(): Flow<PagingData<TvShowsResults>> =
        popularTvShowsPager.pager.cachedIn(viewModelScope)

    @JvmName("getLatestTvShows")
    fun getLatestTvShows(): Flow<PagingData<TvShowsResults>> =
        latestTvShowsPager.pager.cachedIn(viewModelScope)


    fun getReviews(id: Int) = liveData(Dispatchers.IO) {
        val reviews = api.getMovieReviews(id)
        emit(reviews)
    }

    fun getCastMembers(id: Int) = liveData(Dispatchers.IO) {
        val casts = api.getMovieCasts(id)
        emit(casts)
    }

    fun getMovieTrailer(id: Int) = liveData(Dispatchers.IO) {
        val url = api.getMovieTrailer(id)
        emit(url)
    }

    fun getSimilarMovies(id: Int) = liveData(Dispatchers.IO) {
        val similarMovies = api.getSimilarMovies(id)
        emit(similarMovies)
    }

    fun getPopularlyRatedMovies() = liveData(Dispatchers.IO) {
        val topratedMovie = api.getPopularMovies(MovieApi.api_key, 1)
        emit(topratedMovie)
    }

    private val _searchMoviesResponse = MutableLiveData<MovieResponse>()
    val searchMoviesResponse: LiveData<MovieResponse>
        get() = _searchMoviesResponse

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = api.searchMovies(query = query, page = 1)
            if (response.results != null) {
                _searchMoviesResponse.value = response
            } else {
                Log.e("MovieViewModel", "Error: ${response}")
            }
        }
    }

    fun saveFavouriteMovie(movie: FavouriteMovies) = viewModelScope.launch {
        repository.insertFavouriteMovies(movie)
    }

    fun fetchFavouriteMovie() = repository.getFavouriteMovies()

}

