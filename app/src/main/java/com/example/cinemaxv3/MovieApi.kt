package com.example.cinemaxv3

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular?")
    suspend fun getPopularMovies(
        @Query("api_key") api_key:String = "201e657f776a56b669133086996d6564",
        @Query("page") page: Int
    ):Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key:String = "201e657f776a56b669133086996d6564",
        @Query("page") page: Int
    ):Response<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key:String = "201e657f776a56b669133086996d6564",
        @Query("page") page: Int
    ):Response<MovieResponse>


}