package com.example.cinemaxv3.models

import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "movies")
data class Movie(
    val backdrop_path: String?,
    val overview: String?,
    val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val vote_average: Double,
    var page: Int?
) : Serializable


@Entity(tableName = "toprated_movies")
data class TopRatedMovies(
    val backdrop_path: String?,
    val overview: String?,
    val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val vote_average: Double,
    var page: Int?
) : Serializable

@Entity(tableName = "upcoming_movies")
data class UpComingMovies(
    val backdrop_path: String?,
    val overview: String?,
    val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val vote_average: Double,
    var page: Int?
) : Serializable
