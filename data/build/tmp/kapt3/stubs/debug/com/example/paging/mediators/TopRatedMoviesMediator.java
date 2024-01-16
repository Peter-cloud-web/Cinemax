package com.example.paging.mediators;

import androidx.paging.ExperimentalPagingApi;
import androidx.paging.LoadType;
import androidx.paging.PagingState;
import androidx.paging.RemoteMediator;
import com.example.cinemaxv3.models.TopRatedMovies;
import com.example.cinemaxv3.models.TopRatedRemoteKeys;
import com.example.db.MovieDatabase;
import com.example.domain.repository.RemoteMoviesRepository;
import retrofit2.HttpException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\'\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J-\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/paging/mediators/TopRatedMoviesMediator;", "Landroidx/paging/RemoteMediator;", "", "Lcom/example/cinemaxv3/models/TopRatedMovies;", "db", "Lcom/example/db/MovieDatabase;", "repository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "(Lcom/example/db/MovieDatabase;Lcom/example/domain/repository/RemoteMoviesRepository;)V", "getRemoteKeyClosestToCurrentPosition", "Lcom/example/cinemaxv3/models/TopRatedRemoteKeys;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteKeyForFirstItem", "getRemoteKeyForLastItem", "initialize", "Landroidx/paging/RemoteMediator$InitializeAction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/RemoteMediator$MediatorResult;", "loadType", "Landroidx/paging/LoadType;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
public final class TopRatedMoviesMediator extends androidx.paging.RemoteMediator<java.lang.Integer, com.example.cinemaxv3.models.TopRatedMovies> {
    @org.jetbrains.annotations.NotNull
    private final com.example.db.MovieDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.RemoteMoviesRepository repository = null;
    
    public TopRatedMoviesMediator(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase db, @org.jetbrains.annotations.NotNull
    com.example.domain.repository.RemoteMoviesRepository repository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.InitializeAction> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull
    androidx.paging.LoadType loadType, @org.jetbrains.annotations.NotNull
    androidx.paging.PagingState<java.lang.Integer, com.example.cinemaxv3.models.TopRatedMovies> state, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.paging.RemoteMediator.MediatorResult> $completion) {
        return null;
    }
    
    private final java.lang.Object getRemoteKeyClosestToCurrentPosition(androidx.paging.PagingState<java.lang.Integer, com.example.cinemaxv3.models.TopRatedMovies> state, kotlin.coroutines.Continuation<? super com.example.cinemaxv3.models.TopRatedRemoteKeys> $completion) {
        return null;
    }
    
    private final java.lang.Object getRemoteKeyForFirstItem(androidx.paging.PagingState<java.lang.Integer, com.example.cinemaxv3.models.TopRatedMovies> state, kotlin.coroutines.Continuation<? super com.example.cinemaxv3.models.TopRatedRemoteKeys> $completion) {
        return null;
    }
    
    private final java.lang.Object getRemoteKeyForLastItem(androidx.paging.PagingState<java.lang.Integer, com.example.cinemaxv3.models.TopRatedMovies> state, kotlin.coroutines.Continuation<? super com.example.cinemaxv3.models.TopRatedRemoteKeys> $completion) {
        return null;
    }
}