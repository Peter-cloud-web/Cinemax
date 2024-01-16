package com.example.db.dao.movieDaos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import com.example.db.dao.movieDaos.converters.ListConverter;
import com.example.domain.entities.model.favourites.FavouriteMovies;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/db/dao/movieDaos/FavouriteMoviesDao;", "", "deleteFavouriteMovie", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFavouriteMovies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/domain/entities/model/favourites/FavouriteMovies;", "insertFavouriteMovies", "movie", "(Lcom/example/domain/entities/model/favourites/FavouriteMovies;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@androidx.room.Dao
public abstract interface FavouriteMoviesDao {
    
    @androidx.room.Query(value = "SELECT * FROM favourite_movies")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.domain.entities.model.favourites.FavouriteMovies>> getAllFavouriteMovies();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertFavouriteMovies(@org.jetbrains.annotations.NotNull
    com.example.domain.entities.model.favourites.FavouriteMovies movie, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM favourite_movies WHERE  id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFavouriteMovie(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}