package com.example.cinemaxv3.service

import com.example.cinemaxv3.BuildConfig
import com.example.cinemaxv3.models.responses.*
import com.example.cinemaxv3.models.responses.movieCasts.MovieCastsResponse
import com.example.cinemaxv3.models.responses.moviesResponse.MovieResponse
import com.example.cinemaxv3.models.responses.moviesResponse.TopRatedMovieResponse
import com.example.cinemaxv3.models.responses.moviesResponse.UpComingMovieResponse
import com.example.cinemaxv3.models.responses.similarMoviesResponse.SimilarMoviesResponse
import com.example.cinemaxv3.models.responses.trailersResponse.MovieTrailerResponse
import com.example.cinemaxv3.models.responses.tvShowsResponse.TvShowsResponses
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    companion object {
        const val api_key = BuildConfig.MOVIE_API_KEY
    }
    @GET("movie/popular?")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): MovieResponse

    @GET("movie/top_rated?")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): TopRatedMovieResponse

    @GET("movie/upcoming?")
    suspend fun upComingMovies(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,

    ): UpComingMovieResponse

    @GET("movie/{movieId}/reviews")
    suspend fun getMovieReviews(
        @Path("movieId") movieId: Int,
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): ReviewsResponse

    @GET("tv/top_rated?")
    suspend fun getTopRatedTvShows(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): TvShowsResponses

    @GET("movie/{movie_id}/videos?")
    suspend fun getMovieTrailer(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("language") language: String = "en-US",
    ): MovieTrailerResponse

    @GET("movie/{movie_id}/credits?")
    suspend fun getMovieCasts(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("language") language: String = "en-US",
    ): MovieCastsResponse

    @GET("movie/{movie_id}/similar?")
    suspend fun getSimilarMovies(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("language") language: String = "en-US",
    ): SimilarMoviesResponse
}