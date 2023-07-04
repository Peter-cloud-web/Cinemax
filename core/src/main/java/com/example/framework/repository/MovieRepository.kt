package com.example.framework.repository

import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.framework.common.Resource
import com.example.framework.model.favourites.FavouriteMovies
import com.example.framework.model.movieCasts.MovieCastsResponse
import com.example.framework.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.framework.model.trailersResponse.MovieTrailerResponse
import com.example.framework.model.tvShowsResponse.TvShowsResponses
import com.example.framework.movieDto.MovieResponseDto
import com.example.framework.movieDto.TopRatedMovieResponseDto
import com.example.framework.movieDto.UpComingMovieResponseDto
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getTopRatedMovies(page: Int): Resource<TopRatedMovieResponseDto>

    suspend fun getPopularMovies(page: Int): Resource<MovieResponseDto>

    suspend fun getUpComingMovies(page: Int): Resource<UpComingMovieResponseDto>

    suspend fun getMovieReviews(movieId: Int): Resource<ReviewsResponse>

    suspend fun getTopRatedTvShows(page: Int): Resource<TvShowsResponses>

    suspend fun getPopularTvShows(page: Int): Resource<TvShowsResponses>

    suspend fun getTvShowsAiringToday(page: Int): Resource<TvShowsResponses>

    suspend fun getTvShowsOnTheAir(page: Int): Resource<TvShowsResponses>

    suspend fun getMovieTrailers(id: Int): Resource<MovieTrailerResponse>

    suspend fun getMovieCasts(id: Int): Resource<MovieCastsResponse>

    suspend fun getSimilarMovies(id: Int): Resource<SimilarMoviesResponse>

    suspend fun getSearchedMovies(
        query: String,
        page: Int
    ): Resource<MovieResponseDto>

    fun getFavouriteMovies(): Flow<List<FavouriteMovies>>

    suspend fun insertFavouriteMovies(favouriteMovies: FavouriteMovies)

}