package com.example.framework.movieDto

import com.example.cinemaxv3.models.UpComingMovies
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UpComingMovieResponseDto (
    @SerialName("page") val page: Int,
    @SerialName("results") val movies: List<UpComingMoviesDto>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int)