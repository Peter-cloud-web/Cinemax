package com.example.cinemaxv3.service

import com.example.cinemaxv3.BuildConfig
import com.example.cinemaxv3.models.responses.*
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

}