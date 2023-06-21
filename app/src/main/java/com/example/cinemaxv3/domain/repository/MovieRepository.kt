package com.example.cinemaxv3.domain.repository

import androidx.lifecycle.LiveData
import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.data.remote.dto.movieDto.MovieDto
import com.example.cinemaxv3.data.remote.dto.movieDto.MovieResponseDto
import com.example.cinemaxv3.data.remote.dto.movieDto.TopRatedMovieResponseDto
import com.example.cinemaxv3.data.remote.dto.movieDto.TopRatedMoviesDto
import com.example.cinemaxv3.data.remote.dto.movieDto.UpComingMovieResponseDto
import com.example.cinemaxv3.data.remote.dto.movieDto.UpComingMoviesDto
import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.domain.model.movieCasts.MovieCastsResponse
import com.example.cinemaxv3.domain.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.cinemaxv3.domain.model.trailersResponse.MovieTrailerResponse
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
import com.example.cinemaxv3.models.responses.ReviewsResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getTopRatedMovies(page:Int): Resource<TopRatedMovieResponseDto>

    suspend fun getPopularMovies(page: Int) : Resource<MovieResponseDto>

    suspend fun getUpComingMovies(page: Int):Resource<UpComingMovieResponseDto>

    suspend fun getMovieReviews(movieId:Int):Resource<ReviewsResponse>

    suspend fun getTopRatedTvShows(page: Int): Resource<TvShowsResponses>

    suspend fun getPopularTvShows(page: Int):Resource<TvShowsResponses>

    suspend fun getTvShowsAiringToday(page: Int):Resource<TvShowsResponses>

    suspend fun getTvShowsOnTheAir(page: Int):Resource<TvShowsResponses>

    suspend fun getMovieTrailers(id:Int):Resource<MovieTrailerResponse>

    suspend fun getMovieCasts(id:Int):Resource<MovieCastsResponse>

    suspend fun getSimilarMovies(id: Int):Resource<SimilarMoviesResponse>

    suspend fun getSearchedMovies(query:String,page:Int):Resource<MovieResponseDto>

    fun getFavouriteMovies(): Flow<List<FavouriteMovies>>

    suspend fun insertFavouriteMovies(favouriteMovies: FavouriteMovies)

}