package com.example.cinemaxv3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_key")
data class MovieRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "movie_id")
    val MovieID:Int,
    val prevKey:Int?,
    val currentPage:Int,
    val nextKey:Int?,
    @ColumnInfo(name = "created_at")
    val createdAt:Long = System.currentTimeMillis()
)
