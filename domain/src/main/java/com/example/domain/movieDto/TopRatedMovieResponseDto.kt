package com.example.domain.movieDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopRatedMovieResponseDto(
    @SerialName("page") val page: Int,
    @SerialName("results") val movies: List<TopRatedMoviesDto>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int
)