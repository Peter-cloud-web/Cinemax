package com.example.data.repository;

import com.example.cinemaxv3.models.responses.ReviewsResponse;
import com.example.data.MovieApi;
import com.example.db.MovieDatabase;
import com.example.domain.common.Resource;
import com.example.domain.entities.model.movieCasts.MovieCastsResponse;
import com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse;
import com.example.domain.entities.model.trailersResponse.MovieTrailerResponse;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResponses;
import com.example.domain.movieDto.MovieResponseDto;
import com.example.domain.movieDto.TopRatedMovieResponseDto;
import com.example.domain.movieDto.UpComingMovieResponseDto;
import com.example.domain.repository.RemoteMoviesRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/example/data/repository/RemoteMoviesRepositoryImpl;", "Lcom/example/domain/repository/RemoteMoviesRepository;", "movieApi", "Lcom/example/data/MovieApi;", "(Lcom/example/data/MovieApi;)V", "getMovieCasts", "Lcom/example/domain/common/Resource;", "Lcom/example/domain/entities/model/movieCasts/MovieCastsResponse;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieReviews", "Lcom/example/cinemaxv3/models/responses/ReviewsResponse;", "getMovieTrailers", "Lcom/example/domain/entities/model/trailersResponse/MovieTrailerResponse;", "getPopularMovies", "Lcom/example/domain/movieDto/MovieResponseDto;", "page", "getPopularTvShows", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResponses;", "getSearchedMovies", "query", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSimilarMovies", "Lcom/example/domain/entities/model/similarMoviesResponse/SimilarMoviesResponse;", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedMovies", "Lcom/example/domain/movieDto/TopRatedMovieResponseDto;", "getTopRatedTvShows", "getTvShowsAiringToday", "getTvShowsOnTheAir", "getUpComingMovies", "Lcom/example/domain/movieDto/UpComingMovieResponseDto;", "data_debug"})
public final class RemoteMoviesRepositoryImpl implements com.example.domain.repository.RemoteMoviesRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.MovieApi movieApi = null;
    
    @javax.inject.Inject
    public RemoteMoviesRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.example.data.MovieApi movieApi) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTopRatedMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.TopRatedMovieResponseDto>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getPopularMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.MovieResponseDto>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUpComingMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.UpComingMovieResponseDto>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieReviews(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.cinemaxv3.models.responses.ReviewsResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTopRatedTvShows(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getPopularTvShows(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTvShowsAiringToday(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTvShowsOnTheAir(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieTrailers(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.trailersResponse.MovieTrailerResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieCasts(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.movieCasts.MovieCastsResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getSimilarMovies(int id, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getSearchedMovies(@org.jetbrains.annotations.NotNull
    java.lang.String query, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.MovieResponseDto>> $completion) {
        return null;
    }
}