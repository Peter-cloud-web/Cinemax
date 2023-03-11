package com.example.cinemaxv3.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cinemaxv3.db.dao.movieDaos.MovieDao
import com.example.cinemaxv3.db.dao.movieDaos.TopRatedMoviesDao
import com.example.cinemaxv3.db.dao.movieDaos.UpComingMoviesDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.RemoteKeysDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.UpComingRemoteKeyDao
import com.example.cinemaxv3.models.*
import com.example.cinemaxv3.util.ListConverter

@Database(
    entities = [
        Movie::class,
        TopRatedMovies::class,
        UpComingMovies::class,

        MovieRemoteKeys::class,
        TopRatedRemoteKeys::class,
        UpComingRemoteKeys::class],
    version = 6
)
@TypeConverters(ListConverter::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao
    abstract fun getUpComingMoviesDao(): UpComingMoviesDao
    abstract fun getUpComingRemoteKeysDao(): UpComingRemoteKeyDao
    abstract fun getTopRatedMoviesDao(): TopRatedMoviesDao
    abstract fun getTopRatedRemoteKeysDao(): TopRatedRemoteKeysDao

}