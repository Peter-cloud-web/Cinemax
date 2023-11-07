package com.example.cinemaxv3.presentation.ui.viewmodels.upComingMoviesViewModel;

import androidx.paging.PagingData;
import com.example.cinemaxv3.models.UpComingMovies;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/upComingMoviesViewModel/UpComingMoviesUiState;", "", "isLoading", "", "upComingMovies", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/cinemaxv3/models/UpComingMovies;", "error", "", "(ZLkotlinx/coroutines/flow/Flow;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "()Z", "getUpComingMovies", "()Lkotlinx/coroutines/flow/Flow;", "presentation_debug"})
public final class UpComingMoviesUiState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.cinemaxv3.models.UpComingMovies>> upComingMovies = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String error = null;
    
    public UpComingMoviesUiState(boolean isLoading, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.cinemaxv3.models.UpComingMovies>> upComingMovies, @org.jetbrains.annotations.NotNull
    java.lang.String error) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.cinemaxv3.models.UpComingMovies>> getUpComingMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getError() {
        return null;
    }
    
    public UpComingMoviesUiState() {
        super();
    }
}