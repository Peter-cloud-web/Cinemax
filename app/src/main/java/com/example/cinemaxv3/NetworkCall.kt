package com.example.cinemaxv3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.annotation.RetentionPolicy

const val BASE_URL = "https://api.themoviedb.org/3/ "
object NetworkCall {

    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val invokeMovieApi:MovieApi by lazy{
        provideRetrofit().create(MovieApi::class.java)
    }
}