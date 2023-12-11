package com.example.domain.movieDto

import androidx.room.*
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import java.io.Serializable


@kotlinx.serialization.Serializable
data class MovieDto(
    @SerialName("adult") val adult: Boolean?,
    @SerialName("backdrop_path") val backdrop_path: String?,
    @SerialName("genre_ids") val genre_ids: List<Int>?,
    @SerialName("original_language") val original_language: String?,
    @SerialName("original_title") val original_title: String?,
    @SerialName("overview") val overview: String?,
    @SerialName("popularity") val popularity: Double?,
    @SerialName("poster_path") val poster_path: String?,
    @SerialName("release_date") val release_date: String?,

    @PrimaryKey(autoGenerate = true)
    @SerialName("id") val id: Int,


    @SerialName("title") val title: String?,
    @SerialName("video") val video: Boolean?,
    @SerialName("vote_average") val vote_average: Double,
    @SerialName("vote_count") val vote_count: Int?,
) : Serializable


@kotlinx.serialization.Serializable
data class TopRatedMoviesDto(
    @SerialName("adult") val adult: Boolean?,
    @SerialName("backdrop_path") val backdrop_path: String?,
    @SerialName("genre_ids") val genre_ids: List<Int>?,
    @SerialName("original_language") val original_language: String?,
    @SerialName("original_title") val original_title: String?,
    @SerialName("overview") val overview: String?,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val poster_path: String?,
    @SerialName("release_date") val release_date: String?,

    @PrimaryKey(autoGenerate = true)
    @SerialName("id") val id: Int,

    @SerialName("title") val title: String?,
    @SerialName("video") val video: Boolean?,
    @SerialName("vote_average") val vote_average: Double,
    @SerialName("vote_count") val vote_count: Int?
) : Serializable


@kotlinx.serialization.Serializable
data class UpComingMoviesDto(

    @SerialName("adult") val adult: Boolean?,
    @SerialName("backdrop_path") val backdrop_path: String?,
    @SerialName("genre_ids") val genre_ids: List<Int>?,
    @SerialName("original_language") val original_language: String?,
    @SerialName("original_title") val original_title: String?,
    @SerialName("overview") val overview: String?,
    @SerialName("popularity") val popularity: Double?,
    @SerialName("poster_path") val poster_path: String?,
    @SerialName("release_date") val release_date: String?,

    @PrimaryKey(autoGenerate = true)
    @SerialName("id") val id: Int,

    @SerialName("title") val title: String?,
    @SerialName("video") val video: Boolean?,
    @SerialName("vote_average") val vote_average: Double,
    @SerialName("vote_count") val vote_count: Int?
) : Serializable

