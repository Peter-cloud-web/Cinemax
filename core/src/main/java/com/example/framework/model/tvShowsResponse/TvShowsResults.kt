package com.example.framework.model.tvShowsResponse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.framework.converter.ListConverter

@TypeConverters(ListConverter::class)
@Entity(tableName = "toprated_movieshows")
data class TvShowsResults(
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val origin_country: List<String>?,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int,
    @ColumnInfo(name = "page") var page: Int?
)