package com.example.domain.entities.model.favourites

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(tableName = "favourite_movies")

data class FavouriteMovies(

    @SerializedName("backdrop_path") val backdrop_path: String?,

    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val poster_path: String?,


    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,

    @SerializedName("title") val title: String?,
    @SerializedName("vote_average") val vote_average: Float,

    ) : Serializable
