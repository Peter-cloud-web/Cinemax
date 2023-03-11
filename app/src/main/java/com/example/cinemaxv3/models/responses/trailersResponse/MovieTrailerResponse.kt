package com.example.cinemaxv3.models.responses.trailersResponse

import com.google.gson.annotations.SerializedName

data class MovieTrailerResponse(
    @SerializedName("id")val id: Int,
    @SerializedName("results")  val results: List<TrailerResults>
)