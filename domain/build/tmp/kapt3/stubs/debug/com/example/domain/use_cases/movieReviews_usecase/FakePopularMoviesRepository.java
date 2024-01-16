package com.example.domain.use_cases.movieReviews_usecase;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/example/domain/use_cases/movieReviews_usecase/FakePopularMoviesRepository;", "Lcom/example/domain/repository/RemoteMoviesRepository;", "()V", "reviewList", "", "Lcom/example/cinemaxv3/models/responses/Review;", "getReviewList", "()Ljava/util/List;", "reviews", "Lcom/example/cinemaxv3/models/responses/ReviewsResponse;", "getReviews", "()Lcom/example/cinemaxv3/models/responses/ReviewsResponse;", "getMovieCasts", "Lcom/example/domain/common/Resource;", "Lcom/example/domain/entities/model/movieCasts/MovieCastsResponse;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieReviews", "movieId", "getMovieTrailers", "Lcom/example/domain/entities/model/trailersResponse/MovieTrailerResponse;", "getPopularMovies", "Lcom/example/domain/movieDto/MovieResponseDto;", "page", "getPopularTvShows", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResponses;", "getSearchedMovies", "query", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSimilarMovies", "Lcom/example/domain/entities/model/similarMoviesResponse/SimilarMoviesResponse;", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRatedMovies", "Lcom/example/domain/movieDto/TopRatedMovieResponseDto;", "getTopRatedTvShows", "getTvShowsAiringToday", "getTvShowsOnTheAir", "getUpComingMovies", "Lcom/example/domain/movieDto/UpComingMovieResponseDto;", "domain_debug"})
public final class FakePopularMoviesRepository implements com.example.domain.repository.RemoteMoviesRepository {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.cinemaxv3.models.responses.Review> reviewList = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.cinemaxv3.models.responses.ReviewsResponse reviews = null;
    
    public FakePopularMoviesRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.cinemaxv3.models.responses.Review> getReviewList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.cinemaxv3.models.responses.ReviewsResponse getReviews() {
        return null;
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
    public java.lang.Object getMovieReviews(int movieId, @org.jetbrains.annotations.NotNull
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