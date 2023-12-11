package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.db.MovieDatabase
import com.example.db.dao.movieDaos.MovieDao
import com.example.db.dao.movieDaos.TopRatedMoviesDao
import com.example.db.dao.movieDaos.UpComingMoviesDao
import com.example.db.dao.remoteKeysDaos.RemoteKeysDao
import com.example.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao
import com.example.db.dao.remoteKeysDaos.UpComingRemoteKeyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext androidContext: Context) =
        Room.databaseBuilder(androidContext, MovieDatabase::class.java, "movie_database")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun ProvidesMovieDao(database: MovieDatabase): MovieDao {
        return database.getMovieDao()
    }

    @Singleton
    @Provides
    fun providesRemoteKeysDao(database: MovieDatabase): RemoteKeysDao {
        return database.getRemoteKeysDao()
    }

    @Singleton
    @Provides
    fun ProvidesTopRatedMovieDao(database: MovieDatabase): TopRatedMoviesDao {
        return database.getTopRatedMoviesDao()
    }

    @Singleton
    @Provides
    fun providesTopRatedRemoteKeysDao(database: MovieDatabase): TopRatedRemoteKeysDao {
        return database.getTopRatedRemoteKeysDao()
    }

    @Singleton
    @Provides
    fun ProvidesUpComingMovieDao(database: MovieDatabase): UpComingMoviesDao {
        return database.getUpComingMoviesDao()
    }

    @Singleton
    @Provides
    fun provideUpComingRemoteKeysDao(database: MovieDatabase): UpComingRemoteKeyDao {
        return database.getUpComingRemoteKeysDao()
    }
}