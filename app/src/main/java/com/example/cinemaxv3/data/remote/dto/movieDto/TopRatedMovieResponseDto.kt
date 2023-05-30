package com.example.cinemaxv3.data.remote.dto.movieDto

import com.example.cinemaxv3.models.TopRatedMovies
import com.google.gson.annotations.SerializedName

data class TopRatedMovieResponseDto (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<TopRatedMoviesDto>,
    @SerializedName("total_pages") val pages: Int)