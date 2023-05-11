package com.example.cinemaxv3.models.responses.moviesResponse

import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.UpComingMovies
import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_pages") val pages: Int)