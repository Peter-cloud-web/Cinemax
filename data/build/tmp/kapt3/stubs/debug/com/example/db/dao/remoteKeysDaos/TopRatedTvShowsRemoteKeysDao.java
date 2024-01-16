package com.example.db.dao.remoteKeysDaos;

import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys;
import com.example.cinemaxv3.models.UpComingMovies;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/db/dao/remoteKeysDaos/TopRatedTvShowsRemoteKeysDao;", "", "clearTopRatedTvShowsRemoteKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedTvShowsRemoteKeysById", "Lcom/example/cinemaxv3/models/TopRatedTvShowsRemoteKeys;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedTvShowsRemoteKeysCreaionTime", "", "insertTopRatedTvShowsRemoteKeys", "topRatedTvShowsRemoteKeys", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@androidx.room.Dao
public abstract interface TopRatedTvShowsRemoteKeysDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTopRatedTvShowsRemoteKeys(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys> topRatedTvShowsRemoteKeys, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM toprated_tvshows_remote_keys Where movie_id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopRatedTvShowsRemoteKeysById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.cinemaxv3.models.TopRatedTvShowsRemoteKeys> $completion);
    
    @androidx.room.Query(value = "Delete From  toprated_tvshows_remote_keys")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearTopRatedTvShowsRemoteKeys(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "Select created_at From toprated_tvshows_remote_keys Order By created_at DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopRatedTvShowsRemoteKeysCreaionTime(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}