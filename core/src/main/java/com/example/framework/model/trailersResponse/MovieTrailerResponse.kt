package com.example.framework.model.trailersResponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class MovieTrailerResponse(
    @SerialName("id")val id: Int,
    @SerialName("results")  val results: List<TrailerResults>
)