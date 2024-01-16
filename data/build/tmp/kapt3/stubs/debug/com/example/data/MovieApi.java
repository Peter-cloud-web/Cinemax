package com.example.data;

import com.example.cinemaxv3.models.responses.ReviewsResponse;
import com.example.domain.common.Resource;
import com.example.domain.entities.model.movieCasts.MovieCastsResponse;
import com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse;
import com.example.domain.entities.model.trailersResponse.MovieTrailerResponse;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResponses;
import com.example.domain.movieDto.MovieResponseDto;
import com.example.domain.movieDto.TopRatedMovieResponseDto;
import com.example.domain.movieDto.UpComingMovieResponseDto;
import com.example.util.Constants;
import io.ktor.http.URLProtocol;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/example/data/MovieApi;", "", "httpClient", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "getApiRequest", "Lcom/example/domain/common/Resource;", "T", "urlPath", "", "page", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieCasts", "Lcom/example/domain/entities/model/movieCasts/MovieCastsResponse;", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieReviews", "Lcom/example/cinemaxv3/models/responses/ReviewsResponse;", "getMovieTrailers", "Lcom/example/domain/entities/model/trailersResponse/MovieTrailerResponse;", "getPopularMovies", "Lcom/example/domain/movieDto/MovieResponseDto;", "getPopularTvShows", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResponses;", "getSearchedMovies", "query", "getSimilarMovies", "Lcom/example/domain/entities/model/similarMoviesResponse/SimilarMoviesResponse;", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedMovies", "Lcom/example/domain/movieDto/TopRatedMovieResponseDto;", "getTopRatedTvShows", "getTvShowsAiringToday", "getTvShowsOnTheAir", "getUpComingMovies", "Lcom/example/domain/movieDto/UpComingMovieResponseDto;", "data_debug"})
public final class MovieApi {
    @org.jetbrains.annotations.NotNull
    private final io.ktor.client.HttpClient httpClient = null;
    
    @javax.inject.Inject
    public MovieApi(@org.jetbrains.annotations.NotNull
    io.ktor.client.HttpClient httpClient) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTopRatedMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.TopRatedMovieResponseDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPopularMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.MovieResponseDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUpComingMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.UpComingMovieResponseDto>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMovieReviews(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.cinemaxv3.models.responses.ReviewsResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTopRatedTvShows(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPopularTvShows(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTvShowsAiringToday(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTvShowsOnTheAir(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMovieTrailers(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.trailersResponse.MovieTrailerResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMovieCasts(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.movieCasts.MovieCastsResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSimilarMovies(int id, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSearchedMovies(@org.jetbrains.annotations.NotNull
    java.lang.String query, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.MovieResponseDto>> $completion) {
        return null;
    }
}