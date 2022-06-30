package com.example.cinemaxv3

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int)
