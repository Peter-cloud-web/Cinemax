package com.example.db.dao.movieDaos;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import com.example.db.dao.movieDaos.converters.ListConverter;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\'J\u001f\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/db/dao/movieDaos/TopRatedTvShowsDao;", "", "clearAllMovies", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedTvShows", "Landroidx/paging/PagingSource;", "", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "insertsTopRatedTvShows", "topRatedTvShows", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@androidx.room.Dao
public abstract interface TopRatedTvShowsDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertsTopRatedTvShows(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.domain.entities.model.tvShowsResponse.TvShowsResults> topRatedTvShows, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM toprated_movieshows Order By page")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.example.domain.entities.model.tvShowsResponse.TvShowsResults> getTopRatedTvShows();
    
    @androidx.room.Query(value = "Delete From toprated_movieshows")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearAllMovies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}