package com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel;

import androidx.paging.PagingData;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0004H\u00c6\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\tH\u00c6\u0003J9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\rR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularMoviesViewModel/UiStates;", "T", "", "isLoading", "", "movies", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "error", "", "(ZLkotlinx/coroutines/flow/Flow;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "()Z", "getMovies", "()Lkotlinx/coroutines/flow/Flow;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "presentation_debug"})
public final class UiStates<T extends java.lang.Object> {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<T>> movies = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    
    public UiStates(boolean isLoading, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<T>> movies, @org.jetbrains.annotations.NotNull
    java.lang.String error) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<T>> getMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getError() {
        return null;
    }
    
    public UiStates() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<T>> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel.UiStates<T> copy(boolean isLoading, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<T>> movies, @org.jetbrains.annotations.NotNull
    java.lang.String error) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}