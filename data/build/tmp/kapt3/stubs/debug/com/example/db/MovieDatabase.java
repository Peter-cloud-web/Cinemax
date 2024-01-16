package com.example.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.cinemaxv3.models.Movie;
import com.example.cinemaxv3.models.MovieRemoteKeys;
import com.example.cinemaxv3.models.TopRatedMovies;
import com.example.cinemaxv3.models.TopRatedRemoteKeys;
import com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys;
import com.example.cinemaxv3.models.UpComingMovies;
import com.example.cinemaxv3.models.UpComingRemoteKeys;
import com.example.db.dao.movieDaos.FavouriteMoviesDao;
import com.example.db.dao.movieDaos.MovieDao;
import com.example.db.dao.movieDaos.TopRatedMoviesDao;
import com.example.db.dao.movieDaos.TopRatedTvShowsDao;
import com.example.db.dao.movieDaos.UpComingMoviesDao;
import com.example.db.dao.movieDaos.converters.ListConverter;
import com.example.db.dao.remoteKeysDaos.RemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.TopRatedTvShowsRemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao;
import com.example.domain.entities.model.favourites.FavouriteMovies;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/example/db/MovieDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getFavouriteMoviesDao", "Lcom/example/db/dao/movieDaos/FavouriteMoviesDao;", "getMovieDao", "Lcom/example/db/dao/movieDaos/MovieDao;", "getRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/RemoteKeysDao;", "getTopRatedMoviesDao", "Lcom/example/db/dao/movieDaos/TopRatedMoviesDao;", "getTopRatedRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/TopRatedRemoteKeysDao;", "getTopRatedTvShowsDao", "Lcom/example/db/dao/movieDaos/TopRatedTvShowsDao;", "getTopRatedTvShowsRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/TopRatedTvShowsRemoteKeysDao;", "getUpComingMoviesDao", "Lcom/example/db/dao/movieDaos/UpComingMoviesDao;", "getUpComingRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/UpComingRemoteKeyDao;", "data_debug"})
@androidx.room.Database(entities = {com.example.cinemaxv3.models.Movie.class, com.example.cinemaxv3.models.TopRatedMovies.class, com.example.cinemaxv3.models.UpComingMovies.class, com.example.domain.entities.model.tvShowsResponse.TvShowsResults.class, com.example.domain.entities.model.favourites.FavouriteMovies.class, com.example.cinemaxv3.models.MovieRemoteKeys.class, com.example.cinemaxv3.models.TopRatedRemoteKeys.class, com.example.cinemaxv3.models.UpComingRemoteKeys.class, com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys.class}, version = 17, exportSchema = false)
@androidx.room.TypeConverters(value = {com.example.db.dao.movieDaos.converters.ListConverter.class})
public abstract class MovieDatabase extends androidx.room.RoomDatabase {
    
    public MovieDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.movieDaos.MovieDao getMovieDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.remoteKeysDaos.RemoteKeysDao getRemoteKeysDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.movieDaos.UpComingMoviesDao getUpComingMoviesDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao getUpComingRemoteKeysDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.movieDaos.TopRatedMoviesDao getTopRatedMoviesDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao getTopRatedRemoteKeysDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.movieDaos.TopRatedTvShowsDao getTopRatedTvShowsDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.remoteKeysDaos.TopRatedTvShowsRemoteKeysDao getTopRatedTvShowsRemoteKeysDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.db.dao.movieDaos.FavouriteMoviesDao getFavouriteMoviesDao();
}