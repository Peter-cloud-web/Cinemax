package com.example.framework.model.trailersResponse

import com.google.gson.annotations.SerializedName

data class MovieTrailerResponse(
    @SerializedName("id")val id: Int,
    @SerializedName("results")  val results: List<TrailerResults>
)