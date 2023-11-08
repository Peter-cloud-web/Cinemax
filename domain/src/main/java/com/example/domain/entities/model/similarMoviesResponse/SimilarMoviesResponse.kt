package com.example.domain.entities.model.similarMoviesResponse

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimilarMoviesResponse(
    val page: Int?,
    @SerialName("results")val results: List<SimilarMovies>?,
    val total_pages: Int?,
    val total_results: Int?
)