package com.example.di

import com.example.data.repository.CachedMoviesRepositoryImpl
import com.example.data.repository.RemoteMoviesRepositoryImpl
import com.example.domain.repository.CachedMoviesRepository
import com.example.domain.repository.RemoteMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRemoteMoviesRepository(movieRepositoryImpl: RemoteMoviesRepositoryImpl): RemoteMoviesRepository

    @Binds
    abstract fun bindCachedMoviesRepository(movieRepositoryImpl: CachedMoviesRepositoryImpl): CachedMoviesRepository
}
