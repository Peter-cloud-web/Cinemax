package com.example.domain.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/example/domain/repository/RemoteMoviesRepository;", "", "getMovieCasts", "Lcom/example/domain/common/Resource;", "Lcom/example/domain/entities/model/movieCasts/MovieCastsResponse;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieReviews", "Lcom/example/cinemaxv3/models/responses/ReviewsResponse;", "movieId", "getMovieTrailers", "Lcom/example/domain/entities/model/trailersResponse/MovieTrailerResponse;", "getPopularMovies", "Lcom/example/domain/movieDto/MovieResponseDto;", "page", "getPopularTvShows", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResponses;", "getSearchedMovies", "query", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSimilarMovies", "Lcom/example/domain/entities/model/similarMoviesResponse/SimilarMoviesResponse;", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedMovies", "Lcom/example/domain/movieDto/TopRatedMovieResponseDto;", "getTopRatedTvShows", "getTvShowsAiringToday", "getTvShowsOnTheAir", "getUpComingMovies", "Lcom/example/domain/movieDto/UpComingMovieResponseDto;", "domain_debug"})
public abstract interface RemoteMoviesRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopRatedMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.TopRatedMovieResponseDto>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPopularMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.MovieResponseDto>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUpComingMovies(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.UpComingMovieResponseDto>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieReviews(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.cinemaxv3.models.responses.ReviewsResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopRatedTvShows(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPopularTvShows(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTvShowsAiringToday(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTvShowsOnTheAir(int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.tvShowsResponse.TvShowsResponses>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieTrailers(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.trailersResponse.MovieTrailerResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieCasts(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.movieCasts.MovieCastsResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSimilarMovies(int id, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSearchedMovies(@org.jetbrains.annotations.NotNull
    java.lang.String query, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.domain.common.Resource<com.example.domain.movieDto.MovieResponseDto>> $completion);
}