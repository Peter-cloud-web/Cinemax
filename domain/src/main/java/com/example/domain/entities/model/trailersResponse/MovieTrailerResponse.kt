package com.example.domain.entities.model.trailersResponse

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieTrailerResponse(
    @SerialName("id")val id: Int,
    @SerialName("results")  val results: List<TrailerResults>
)