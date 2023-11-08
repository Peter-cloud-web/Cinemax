package com.example.cinemaxv3.view.ui.viewmodels.movieReviewsViewModel;

import androidx.lifecycle.MutableLiveData;
import com.example.cinemaxv3.models.responses.Review;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\tH\u00c6\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR!\u0010\u0004\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieReviewsViewModel/MovieReviewsUiStates;", "", "isLoading", "", "isSuccess", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/cinemaxv3/models/responses/Review;", "isError", "", "(ZLandroidx/lifecycle/MutableLiveData;Ljava/lang/String;)V", "()Ljava/lang/String;", "()Z", "()Landroidx/lifecycle/MutableLiveData;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "presentation_debug"})
public final class MovieReviewsUiStates {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.cinemaxv3.models.responses.Review>> isSuccess = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String isError = null;
    
    public MovieReviewsUiStates(boolean isLoading, @org.jetbrains.annotations.Nullable
    androidx.lifecycle.MutableLiveData<java.util.List<com.example.cinemaxv3.models.responses.Review>> isSuccess, @org.jetbrains.annotations.NotNull
    java.lang.String isError) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.cinemaxv3.models.responses.Review>> isSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String isError() {
        return null;
    }
    
    public MovieReviewsUiStates() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.cinemaxv3.models.responses.Review>> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.cinemaxv3.view.ui.viewmodels.movieReviewsViewModel.MovieReviewsUiStates copy(boolean isLoading, @org.jetbrains.annotations.Nullable
    androidx.lifecycle.MutableLiveData<java.util.List<com.example.cinemaxv3.models.responses.Review>> isSuccess, @org.jetbrains.annotations.NotNull
    java.lang.String isError) {
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