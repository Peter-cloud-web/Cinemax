package com.example.cinemaxv3.models.latest

data class LastEpisodeToAir(
    val air_date: String,
    val episode_number: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val production_code: String,
    val runtime: Any,
    val season_number: Int,
    val show_id: Int,
    val still_path: Any,
    val vote_average: Double,
    val vote_count: Int
)