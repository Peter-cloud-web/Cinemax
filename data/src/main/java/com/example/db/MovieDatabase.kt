package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.cinemaxv3.models.TopRatedRemoteKeys
import com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys
import com.example.cinemaxv3.models.UpComingMovies
import com.example.cinemaxv3.models.UpComingRemoteKeys
import com.example.db.dao.movieDaos.FavouriteMoviesDao
import com.example.db.dao.movieDaos.MovieDao
import com.example.db.dao.movieDaos.TopRatedMoviesDao
import com.example.db.dao.movieDaos.TopRatedTvShowsDao
import com.example.db.dao.movieDaos.UpComingMoviesDao
import com.example.db.dao.movieDaos.converters.ListConverter
import com.example.db.dao.remoteKeysDaos.RemoteKeysDao
import com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao
import com.example.db.dao.remoteKeysDaos.TopRatedTvShowsRemoteKeysDao
import com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao
import com.example.domain.entities.model.favourites.FavouriteMovies
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults


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
    version = 17, exportSchema = false
)
@TypeConverters(ListConverter::class)
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