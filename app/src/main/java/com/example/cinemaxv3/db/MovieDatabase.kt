package com.example.cinemaxv3.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinemaxv3.db.dao.movieDaos.FavouriteMoviesDao
import com.example.cinemaxv3.db.dao.movieDaos.MovieDao
import com.example.cinemaxv3.db.dao.movieDaos.TopRatedMoviesDao
import com.example.cinemaxv3.db.dao.movieDaos.TopRatedTvShowsDao
import com.example.cinemaxv3.db.dao.movieDaos.UpComingMoviesDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.RemoteKeysDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.TopRatedTvShowsRemoteKeysDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.UpComingRemoteKeyDao
import com.example.cinemaxv3.models.*
import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResults

@Database(
    entities = [
        Movie::class,
        TopRatedMovies::class,
        UpComingMovies::class,
        TvShowsResults::class,
        FavouriteMovies::class,

        MovieRemoteKeys::class,
        TopRatedRemoteKeys::class,
        UpComingRemoteKeys::class,
         TopRatedTvShowsRemoteKeys::class],
    version = 16
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao
    abstract fun getUpComingMoviesDao(): UpComingMoviesDao
    abstract fun getUpComingRemoteKeysDao(): UpComingRemoteKeyDao
    abstract fun getTopRatedMoviesDao(): TopRatedMoviesDao
    abstract fun getTopRatedRemoteKeysDao(): TopRatedRemoteKeysDao
    abstract fun getTopRatedTvShowsDao(): TopRatedTvShowsDao
    abstract fun getTopRatedTvShowsRemoteKeysDao(): TopRatedTvShowsRemoteKeysDao
    abstract fun getFavouriteMoviesDao(): FavouriteMoviesDao

}