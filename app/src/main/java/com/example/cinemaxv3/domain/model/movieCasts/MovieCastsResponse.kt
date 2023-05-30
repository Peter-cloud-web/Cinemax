package com.example.cinemaxv3.domain.model.movieCasts

data class MovieCastsResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)