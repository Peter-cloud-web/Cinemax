package com.example.di;

import android.content.Context;
import androidx.room.Room;
import com.example.db.MovieDatabase;
import com.example.db.dao.movieDaos.MovieDao;
import com.example.db.dao.movieDaos.TopRatedMoviesDao;
import com.example.db.dao.movieDaos.UpComingMoviesDao;
import com.example.db.dao.remoteKeysDaos.RemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/example/di/RoomModule;", "", "()V", "ProvidesMovieDao", "Lcom/example/db/dao/movieDaos/MovieDao;", "database", "Lcom/example/db/MovieDatabase;", "ProvidesTopRatedMovieDao", "Lcom/example/db/dao/movieDaos/TopRatedMoviesDao;", "ProvidesUpComingMovieDao", "Lcom/example/db/dao/movieDaos/UpComingMoviesDao;", "provideDatabase", "androidContext", "Landroid/content/Context;", "provideUpComingRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/UpComingRemoteKeyDao;", "providesRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/RemoteKeysDao;", "providesTopRatedRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/TopRatedRemoteKeysDao;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RoomModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.di.RoomModule INSTANCE = null;
    
    private RoomModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.db.MovieDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context androidContext) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.db.dao.movieDaos.MovieDao ProvidesMovieDao(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase database) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.db.dao.remoteKeysDaos.RemoteKeysDao providesRemoteKeysDao(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase database) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.db.dao.movieDaos.TopRatedMoviesDao ProvidesTopRatedMovieDao(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase database) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao providesTopRatedRemoteKeysDao(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase database) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.db.dao.movieDaos.UpComingMoviesDao ProvidesUpComingMovieDao(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase database) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao provideUpComingRemoteKeysDao(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase database) {
        return null;
    }
}