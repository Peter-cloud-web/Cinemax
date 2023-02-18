package com.example.cinemaxv3.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cinemaxv3.db.dao.MovieDao
import com.example.cinemaxv3.db.dao.RemoteKeysDao
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.cinemaxv3.util.Converters
import com.example.cinemaxv3.util.ListConverter

@Database(entities = [Movie::class,MovieRemoteKeys::class],version = 1)
@TypeConverters(ListConverter::class)
 abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
    abstract fun getRemoteKeysDao():RemoteKeysDao

}