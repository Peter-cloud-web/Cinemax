package com.example.framework.model.similarMoviesResponse

import com.google.gson.annotations.SerializedName

data class SimilarMoviesResponse(
    val page: Int,
    @SerializedName("results")val results: List<SimilarMovies>,
    val total_pages: Int,
    val total_results: Int
)