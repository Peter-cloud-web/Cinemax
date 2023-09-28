package com.example.framework.model.movieCasts

import kotlinx.serialization.Serializable

@Serializable
data class MovieCastsResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int?
)