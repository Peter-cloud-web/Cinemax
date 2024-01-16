package com.example.db.dao.remoteKeysDaos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.cinemaxv3.models.TopRatedRemoteKeys;
import com.example.cinemaxv3.models.UpComingRemoteKeys;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/db/dao/remoteKeysDaos/UpComingRemoteKeyDao;", "", "clearUpComingRemoteKeys", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpComingCreationTime", "", "getUpComingRemoteKeyByMovieID", "Lcom/example/cinemaxv3/models/UpComingRemoteKeys;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAllUpComingKeys", "upComingRemoteKeys", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@androidx.room.Dao
public abstract interface UpComingRemoteKeyDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertAllUpComingKeys(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.cinemaxv3.models.UpComingRemoteKeys> upComingRemoteKeys, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "Select * From upcoming_remote_keys Where movie_id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUpComingRemoteKeyByMovieID(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.cinemaxv3.models.UpComingRemoteKeys> $completion);
    
    @androidx.room.Query(value = "Delete From upcoming_remote_keys")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearUpComingRemoteKeys(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "Select created_at From upcoming_remote_keys Order By created_at DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUpComingCreationTime(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}