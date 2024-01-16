package com.example.worker;

import android.content.Context;
import androidx.paging.LoadState;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.example.cinemaxv3.models.MovieRemoteKeys;
import com.example.db.MovieDatabase;
import com.example.domain.repository.RemoteMoviesRepository;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/worker/MoviesSyncWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "repository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "db", "Lcom/example/db/MovieDatabase;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/example/domain/repository/RemoteMoviesRepository;Lcom/example/db/MovieDatabase;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_debug"})
public final class MoviesSyncWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.RemoteMoviesRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.db.MovieDatabase db = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_PAGE = "page";
    @org.jetbrains.annotations.NotNull
    public static final com.example.worker.MoviesSyncWorker.Companion Companion = null;
    
    @javax.inject.Inject
    public MoviesSyncWorker(@org.jetbrains.annotations.NotNull
    android.content.Context appContext, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull
    com.example.domain.repository.RemoteMoviesRepository repository, @org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase db) {
        super(null, null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/worker/MoviesSyncWorker$Companion;", "", "()V", "KEY_PAGE", "", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}