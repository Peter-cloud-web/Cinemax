package com.example.cinemaxv3.di;

import android.content.Context;
import androidx.room.Room;
import com.example.cinemaxv3.di.network.TmdbHttpClient;
import com.example.data.repository.MovieRepositoryImpl;
import com.example.db.MovieDatabase;
import com.example.db.dao.movieDaos.MovieDao;
import com.example.db.dao.movieDaos.TopRatedMoviesDao;
import com.example.db.dao.movieDaos.UpComingMoviesDao;
import com.example.db.dao.remoteKeysDaos.RemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao;
import com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao;
import com.example.framework.repository.MovieRepository;
import com.example.service.MovieApi;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0007J\b\u0010\u001a\u001a\u00020\u0018H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006!"}, d2 = {"Lcom/example/cinemaxv3/di/AppModule;", "", "()V", "ProvidesMovieDao", "Lcom/example/db/dao/movieDaos/MovieDao;", "database", "Lcom/example/db/MovieDatabase;", "ProvidesTopRatedMovieDao", "Lcom/example/db/dao/movieDaos/TopRatedMoviesDao;", "ProvidesUpComingMovieDao", "Lcom/example/db/dao/movieDaos/UpComingMoviesDao;", "getHttpClient", "Lio/ktor/client/HttpClient;", "provideBaseUrl", "", "provideCoilImageLoader", "Lcoil/ImageLoader;", "context", "Landroid/content/Context;", "provideDatabase", "provideMovieRepository", "Lcom/example/framework/repository/MovieRepository;", "httpClient", "api", "Lcom/example/service/MovieApi;", "db", "provideRetrofit", "provideUpComingRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/UpComingRemoteKeyDao;", "providesRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/RemoteKeysDao;", "providesTopRatedRemoteKeysDao", "Lcom/example/db/dao/remoteKeysDaos/TopRatedRemoteKeysDao;", "presentation_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.cinemaxv3.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final java.lang.String provideBaseUrl() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.service.MovieApi provideRetrofit() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final coil.ImageLoader provideCoilImageLoader(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.db.MovieDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
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
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final io.ktor.client.HttpClient getHttpClient() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.framework.repository.MovieRepository provideMovieRepository(@org.jetbrains.annotations.NotNull
    io.ktor.client.HttpClient httpClient, @org.jetbrains.annotations.NotNull
    com.example.service.MovieApi api, @org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase db) {
        return null;
    }
}