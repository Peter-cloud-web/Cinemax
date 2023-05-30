package com.example.cinemaxv3.service

import com.example.cinemaxv3.BuildConfig
import com.example.cinemaxv3.models.responses.*
import com.example.cinemaxv3.domain.model.movieCasts.MovieCastsResponse
import com.example.cinemaxv3.data.remote.dto.movieDto.MovieResponseDto
import com.example.cinemaxv3.data.remote.dto.movieDto.TopRatedMovieResponseDto
import com.example.cinemaxv3.data.remote.dto.movieDto.UpComingMovieResponseDto
import com.example.cinemaxv3.domain.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.cinemaxv3.domain.model.trailersResponse.MovieTrailerResponse
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
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
    ): MovieResponseDto

    @GET("movie/top_rated?")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): TopRatedMovieResponseDto

    @GET("movie/upcoming?")
    suspend fun upComingMovies(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): UpComingMovieResponseDto

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

    @GET("tv/popular?")
    suspend fun getPopularTvShows(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): TvShowsResponses

    @GET("tv/on_the_air ?")
    suspend fun getLatestTvShows(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): TvShowsResponses

    @GET("tv/airing_today?")
    suspend fun getTvShowsAiringToday(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("page") page: Int,
    ): TvShowsResponses

    @GET("tv/on_the_air?")
    suspend fun getTvShowsOnTheAir(
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

    @GET("search/movie?")
    suspend fun searchMovies(
        @Query("api_key") api_key: String = MovieApi.api_key,
        @Query("language") language: String = "en-US",
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieResponseDto
}