package com.example.framework.movieDto

import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MovieDto(
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("genre_ids") val genre_ids: List<Int>?,
    @SerializedName("original_language") val original_language: String?,
    @SerializedName(" original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("release_date") val release_date: String?,

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,


    @SerializedName("title") val title: String?,
    @SerializedName("video") val video: Boolean?,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int?,
    @ColumnInfo(name = "page") var page: Int?
) : Serializable


data class TopRatedMoviesDto(
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("genre_ids") val genre_ids: List<Int>?,
    @SerializedName("original_language") val original_language: String?,
    @SerializedName(" original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("release_date") val release_date: String?,

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,

    @SerializedName("title") val title: String?,
    @SerializedName("video") val video: Boolean?,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int?,
    @ColumnInfo(name = "page") var page: Int?
) : Serializable


data class UpComingMoviesDto(

    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdrop_path: String?,
    @SerializedName("genre_ids") val genre_ids: List<Int>?,
    @SerializedName("original_language") val original_language: String?,
    @SerializedName(" original_title") val original_title: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("poster_path") val poster_path: String?,
    @SerializedName("release_date") val release_date: String?,

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,

    @SerializedName("title") val title: String?,
    @SerializedName("video") val video: Boolean?,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int?,
    @ColumnInfo(name = "page") var page: Int?
) : Serializable

