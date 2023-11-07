package com.example.cinemaxv3.models

import androidx.room.*
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Entity(tableName = "movies")
@Serializable
data class Movie(
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName(" original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int?,
    @ColumnInfo(name = "page") var page: Int?
)


@Entity(tableName = "toprated_movies")
@Serializable
data class TopRatedMovies(
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName(" original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int?,
    @ColumnInfo(name = "page") var page: Int?
)

@Entity(tableName = "upcoming_movies")
@Serializable
data class UpComingMovies(
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName(" original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val poster_path: String?,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int?,
    @ColumnInfo(name = "page") var page: Int?
)


data class MovieResponse(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<Movie>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int
)


data class UpcomingMovieResponse(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<TopRatedMovies>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int
)

data class TopratedMovieResponse(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<UpComingMovies>,
    @SerialName("total_pages") val pages: Int,
    @SerialName("total_results") val totalResults: Int
)
