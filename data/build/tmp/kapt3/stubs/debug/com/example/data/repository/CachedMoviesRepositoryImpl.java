package com.example.data.repository;

import com.example.db.MovieDatabase;
import com.example.domain.entities.model.favourites.FavouriteMovies;
import com.example.domain.repository.CachedMoviesRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000bH\u0016J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/data/repository/CachedMoviesRepositoryImpl;", "Lcom/example/domain/repository/CachedMoviesRepository;", "db", "Lcom/example/db/MovieDatabase;", "(Lcom/example/db/MovieDatabase;)V", "deleteFavouriteMovie", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavouriteMovies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/domain/entities/model/favourites/FavouriteMovies;", "insertFavouriteMovies", "favouriteMovies", "(Lcom/example/domain/entities/model/favourites/FavouriteMovies;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class CachedMoviesRepositoryImpl implements com.example.domain.repository.CachedMoviesRepository {
    @org.jetbrains.annotations.Nullable
    private final com.example.db.MovieDatabase db = null;
    
    @javax.inject.Inject
    public CachedMoviesRepositoryImpl(@org.jetbrains.annotations.Nullable
    com.example.db.MovieDatabase db) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.domain.entities.model.favourites.FavouriteMovies>> getFavouriteMovies() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertFavouriteMovies(@org.jetbrains.annotations.NotNull
    com.example.domain.entities.model.favourites.FavouriteMovies favouriteMovies, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteFavouriteMovie(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}