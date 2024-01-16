package com.example.domain.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\bH&J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/domain/repository/CachedMoviesRepository;", "", "deleteFavouriteMovie", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavouriteMovies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/domain/entities/model/favourites/FavouriteMovies;", "insertFavouriteMovies", "favouriteMovies", "(Lcom/example/domain/entities/model/favourites/FavouriteMovies;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_debug"})
public abstract interface CachedMoviesRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.domain.entities.model.favourites.FavouriteMovies>> getFavouriteMovies();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertFavouriteMovies(@org.jetbrains.annotations.NotNull
    com.example.domain.entities.model.favourites.FavouriteMovies favouriteMovies, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFavouriteMovie(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}