package com.example.cinemaxv3.util;

import com.example.cinemaxv3.models.Movie;
import com.example.cinemaxv3.view.ui.fragments.MovieFragmentDirections;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0012\u0010\u000f\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0012\u0010\u0011\u001a\u00020\u0012X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0003\u0015\u0016\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/example/cinemaxv3/util/MovieItem;", "", "()V", "backdrop_path", "", "getBackdrop_path", "()Ljava/lang/String;", "id", "", "getId", "()I", "overview", "getOverview", "poster_path", "getPoster_path", "title", "getTitle", "vote_average", "", "getVote_average", "()F", "Lcom/example/cinemaxv3/util/Movie;", "Lcom/example/cinemaxv3/util/PopularMovie;", "Lcom/example/cinemaxv3/util/TopRatedMovie;", "presentation_debug"})
public abstract class MovieItem {
    
    private MovieItem() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getPoster_path();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getBackdrop_path();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getTitle();
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getOverview();
    
    public abstract float getVote_average();
    
    public abstract int getId();
}