package com.example.di;

import com.example.domain.pager.PopularMoviesPager;
import com.example.domain.pager.PopularTvShowsPager;
import com.example.domain.pager.ToPRatedTvShowsPager;
import com.example.domain.pager.TopRatedMoviesPager;
import com.example.domain.pager.TvShowsAiringTodayPager;
import com.example.domain.pager.TvShowsOnTheAirPager;
import com.example.domain.pager.UpComingPagingMovies;
import com.example.paging.pager.PopularMoviesImpl;
import com.example.paging.pager.PopularTvShowsImpl;
import com.example.paging.pager.TopRatedMovieImpl;
import com.example.paging.pager.TopRatedTvShowsImpl;
import com.example.paging.pager.TvShowsAiringTodayImpl;
import com.example.paging.pager.TvShowsOnTheAirImpl;
import com.example.paging.pager.UpComingMovieImpl;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\'J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\'\u00a8\u0006\u001e"}, d2 = {"Lcom/example/di/PagingModule;", "", "bindPopularMoviesPager", "Lcom/example/domain/pager/PopularMoviesPager;", "popularMovies", "Lcom/example/paging/pager/PopularMoviesImpl;", "bindPopularTvShowsPager", "Lcom/example/domain/pager/PopularTvShowsPager;", "popularTvShowsImpl", "Lcom/example/paging/pager/PopularTvShowsImpl;", "bindTopRatedMoviesPager", "Lcom/example/domain/pager/TopRatedMoviesPager;", "topRatedPagedMovies", "Lcom/example/paging/pager/TopRatedMovieImpl;", "bindTopRatedTvShowsPager", "Lcom/example/domain/pager/ToPRatedTvShowsPager;", "topRatedTvShows", "Lcom/example/paging/pager/TopRatedTvShowsImpl;", "bindTvShowsAiringTodayPager", "Lcom/example/domain/pager/TvShowsAiringTodayPager;", "tvShowsAiringTodayImpl", "Lcom/example/paging/pager/TvShowsAiringTodayImpl;", "bindTvShowsOnTheAirPager", "Lcom/example/domain/pager/TvShowsOnTheAirPager;", "tvShowsOnTheAirImpl", "Lcom/example/paging/pager/TvShowsOnTheAirImpl;", "bindUpComingMoviesPager", "Lcom/example/domain/pager/UpComingPagingMovies;", "upComingMovieImpl", "Lcom/example/paging/pager/UpComingMovieImpl;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract interface PagingModule {
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.pager.PopularMoviesPager bindPopularMoviesPager(@org.jetbrains.annotations.NotNull
    com.example.paging.pager.PopularMoviesImpl popularMovies);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.pager.TopRatedMoviesPager bindTopRatedMoviesPager(@org.jetbrains.annotations.NotNull
    com.example.paging.pager.TopRatedMovieImpl topRatedPagedMovies);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.pager.ToPRatedTvShowsPager bindTopRatedTvShowsPager(@org.jetbrains.annotations.NotNull
    com.example.paging.pager.TopRatedTvShowsImpl topRatedTvShows);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.pager.UpComingPagingMovies bindUpComingMoviesPager(@org.jetbrains.annotations.NotNull
    com.example.paging.pager.UpComingMovieImpl upComingMovieImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.pager.TvShowsAiringTodayPager bindTvShowsAiringTodayPager(@org.jetbrains.annotations.NotNull
    com.example.paging.pager.TvShowsAiringTodayImpl tvShowsAiringTodayImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.pager.TvShowsOnTheAirPager bindTvShowsOnTheAirPager(@org.jetbrains.annotations.NotNull
    com.example.paging.pager.TvShowsOnTheAirImpl tvShowsOnTheAirImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.pager.PopularTvShowsPager bindPopularTvShowsPager(@org.jetbrains.annotations.NotNull
    com.example.paging.pager.PopularTvShowsImpl popularTvShowsImpl);
}