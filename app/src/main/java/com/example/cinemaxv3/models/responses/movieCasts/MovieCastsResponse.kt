package com.example.cinemaxv3.models.responses.movieCasts

data class MovieCastsResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)