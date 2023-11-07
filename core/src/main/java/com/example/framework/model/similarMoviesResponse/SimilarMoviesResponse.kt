package com.example.framework.model.similarMoviesResponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class SimilarMoviesResponse(
    val page: Int?,
    @SerialName("results")val results: List<SimilarMovies>?,
    val total_pages: Int?,
    val total_results: Int?
)