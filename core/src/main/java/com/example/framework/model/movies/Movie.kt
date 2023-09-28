package com.example.cinemaxv3.models

import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "movies")
@kotlinx.serialization.Serializable
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
) : Serializable


@Entity(tableName = "toprated_movies")
@kotlinx.serialization.Serializable
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
) : Serializable

@Entity(tableName = "upcoming_movies")
@kotlinx.serialization.Serializable
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
) : Serializable