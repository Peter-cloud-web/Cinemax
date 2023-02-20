package com.example.cinemaxv3.models.responses

import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.google.gson.annotations.SerializedName

data class TopRatedMovieResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<TopRatedMovies>,
    @SerializedName("total_pages") val pages: Int)