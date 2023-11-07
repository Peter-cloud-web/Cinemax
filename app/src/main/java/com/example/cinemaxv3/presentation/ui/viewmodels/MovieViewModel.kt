package com.example.cinemaxv3.presentation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entities.model.favourites.FavouriteMovies
import com.example.domain.repository.MovieRepository
import com.example.service.MovieApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(
    val api: MovieApi,
    val repository: MovieRepository,


    ) : ViewModel() {
//
//    @OptIn(ExperimentalPagingApi::class)
//    fun getPopularMovies(): Flow<PagingData<Movie>> =
//        popularMoviesPager.pager.cachedIn(viewModelScope)
//
//    @JvmName("getTopRatedMovies")
//    fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> =
//        topRatedMoviesPager.pager.cachedIn(viewModelScope)
//
//    @JvmName("getUpComingMovies")
//    fun getUpComingMovies(): Flow<PagingData<UpComingMovies>> =
//        upComingMoviesPager.pager.cachedIn(viewModelScope)
//
//    @JvmName("getTopRatedTvShows")
//    fun getTopRatedTvShows(): Flow<PagingData<TvShowsResults>> =
//        topRatedTvShowsPager.pager.cachedIn(viewModelScope)
//
//    @JvmName("getPopularTvShows")
//    fun getPopularTvShows(): Flow<PagingData<TvShowsResults>> =
//        popularTvShowsPager.pager.cachedIn(viewModelScope)
//
//    @JvmName("getLatestTvShows")
//    fun getLatestTvShows(): Flow<PagingData<TvShowsResults>> =
//        latestTvShowsPager.pager.cachedIn(viewModelScope)
//
//
//
//    fun getReviews(id: Int) = liveData(Dispatchers.IO) {
//        val reviews = repository.getMovieReviews(id)
//        emit(reviews)
//    }
//
//    fun getCastMembers(id: Int) = liveData(Dispatchers.IO) {
//        val casts = repository.getMovieCasts(id)
//        emit(casts)
//    }
//

//
//    fun getSimilarMovies(id: Int) = liveData(Dispatchers.IO) {
//        val similarMovies = repository.getSimilarMovies(id)
//        emit(similarMovies)
//    }
//

//
//    private val _searchMoviesResponse = MutableLiveData<MovieResponseDto>()
//    val searchMoviesResponse: LiveData<MovieResponseDto>
//        get() = _searchMoviesResponse

//    fun searchMovies(query: String) {
//        viewModelScope.launch {
//            val response = repository.getSearchedMovies(query = "")
//            if (response.results != null) {
//                _searchMoviesResponse.value = response
//            } else {
//                Log.e("MovieViewModel", "Error: ${response}")
//            }
//        }
//    }

    fun saveFavouriteMovie(movie: FavouriteMovies) = viewModelScope.launch {
        repository.insertFavouriteMovies(movie)
    }

    fun fetchFavouriteMovie() = repository.getFavouriteMovies()

}

