package com.example.cinemaxv3.service

import com.example.cinemaxv3.BuildConfig
import com.example.cinemaxv3.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    companion object {
        const val api_key = BuildConfig.MOVIE_API_KEY
    }

    @GET("movie/popular?")
    suspend fun getPopularMovies(
        @Query("api_key") api_key:String =  MovieApi.api_key,
        @Query("page") page: Int,
    ): Response<MovieResponse>

}