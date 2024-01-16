package com.example.di;

import com.example.data.repository.CachedMoviesRepositoryImpl;
import com.example.data.repository.RemoteMoviesRepositoryImpl;
import com.example.domain.repository.CachedMoviesRepository;
import com.example.domain.repository.RemoteMoviesRepository;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/di/RepositoryModule;", "", "()V", "bindCachedMoviesRepository", "Lcom/example/domain/repository/CachedMoviesRepository;", "movieRepositoryImpl", "Lcom/example/data/repository/CachedMoviesRepositoryImpl;", "bindRemoteMoviesRepository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "Lcom/example/data/repository/RemoteMoviesRepositoryImpl;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.repository.RemoteMoviesRepository bindRemoteMoviesRepository(@org.jetbrains.annotations.NotNull
    com.example.data.repository.RemoteMoviesRepositoryImpl movieRepositoryImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.repository.CachedMoviesRepository bindCachedMoviesRepository(@org.jetbrains.annotations.NotNull
    com.example.data.repository.CachedMoviesRepositoryImpl movieRepositoryImpl);
}