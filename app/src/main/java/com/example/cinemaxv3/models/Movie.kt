package com.example.cinemaxv3.models

import androidx.room.*
import com.example.cinemaxv3.util.ListConverter
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@TypeConverters(ListConverter::class)
@Entity(tableName = "movies")
 data class Movie(
    @PrimaryKey(autoGenerate = true)
    var entityId: Int = 0,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdrop_path: String,
    @SerializedName("genre_ids") val genre_ids: List<Int>?,
    @SerializedName("original_language")  val original_language: String,
    @SerializedName(" original_title") val original_title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int
): Serializable
