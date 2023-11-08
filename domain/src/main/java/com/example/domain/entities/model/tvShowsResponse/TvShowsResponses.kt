package com.example.domain.entities.model.tvShowsResponse

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvShowsResponses(
    @SerialName("page")val page: Int,
    @SerialName("results") val results: List<TvShowsResults>,
    @SerialName("total_pages")val total_pages: Int,
    @SerialName("total_results")val total_results: Int
)