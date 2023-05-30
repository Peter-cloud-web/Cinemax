package com.example.cinemaxv3.data.remote.dto.movieDto

import com.example.cinemaxv3.models.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponseDto (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<MovieDto>,
    @SerializedName("total_pages") val pages: Int)