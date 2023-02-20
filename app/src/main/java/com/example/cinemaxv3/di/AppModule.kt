package com.example.cinemaxv3.di

import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverters
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.db.dao.movieDaos.MovieDao
import com.example.cinemaxv3.db.dao.movieDaos.TopRatedMoviesDao
import com.example.cinemaxv3.db.dao.movieDaos.UpComingMoviesDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.RemoteKeysDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.TopRatedRemoteKeysDao
import com.example.cinemaxv3.db.dao.remoteKeysDaos.UpComingRemoteKeyDao
import com.example.cinemaxv3.service.MovieApi
import com.example.cinemaxv3.util.ListConverter
import com.example.cinemaxv3.util.Constants
import com.example.cinemaxv3.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(): MovieApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MovieApi::class.java)

    @Provides
    @Singleton
    @TypeConverters(ListConverter::class)
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MovieDatabase::class.java, "movie_database")
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
    fun providesTopRatedRemoteKeysDao(database: MovieDatabase): TopRatedRemoteKeysDao{
        return database.getTopRatedRemoteKeysDao()
    }

    @Singleton
    @Provides
    fun ProvidesUpComingMovieDao(database: MovieDatabase): UpComingMoviesDao {
        return database.getUpComingMoviesDao()
    }

    @Singleton
    @Provides
    fun provideUpComingRemoteKeysDao(database: MovieDatabase): UpComingRemoteKeyDao{
        return database.getUpComingRemoteKeysDao()
    }

}