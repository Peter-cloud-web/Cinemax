package com.example.framework.model.tvShowsResponse

import com.google.gson.annotations.SerializedName

data class TvShowsResponses(
    @SerializedName("page")val page: Int,
    @SerializedName("results") val results: List<TvShowsResults>,
    @SerializedName("total_pages")val total_pages: Int,
    @SerializedName("total_results")val total_results: Int
)