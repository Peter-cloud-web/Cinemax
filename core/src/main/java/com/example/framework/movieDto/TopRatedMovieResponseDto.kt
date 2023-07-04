package com.example.framework.movieDto

import com.google.gson.annotations.SerializedName

data class TopRatedMovieResponseDto(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<TopRatedMoviesDto>,
    @SerializedName("total_pages") val pages: Int
)