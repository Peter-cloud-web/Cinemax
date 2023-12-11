package com.example.domain.entities.model.tvShowsResponse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.domain.converter.ListConverter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@TypeConverters(ListConverter::class)
@Entity(tableName = "toprated_movieshows")
@Serializable
data class TvShowsResults(
    @SerialName("backdrop_path") val backdrop_path: String,
    @SerialName("first_air_date") val first_air_date: String,
    @SerialName("genre_ids") val genre_ids: List<Int>,

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerialName("name") val name: String,
    @SerialName("origin_country") val origin_country: List<String>?,
    @SerialName("original_language") val original_language: String,
    @SerialName("original_name") val original_name: String,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val poster_path: String,
    @SerialName("vote_average") val vote_average: Double,
    @SerialName("vote_count") val vote_count: Int,



    @ColumnInfo(name = "page") var page: Int?= 1
)