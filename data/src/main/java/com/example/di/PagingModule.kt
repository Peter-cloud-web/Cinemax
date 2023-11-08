package com.example.di

import com.example.domain.pager.PopularMoviesPager
import com.example.domain.pager.PopularTvShowsPager
import com.example.domain.pager.ToPRatedTvShowsPager
import com.example.domain.pager.TopRatedMoviesPager
import com.example.domain.pager.TvShowsAiringTodayPager
import com.example.domain.pager.TvShowsOnTheAirPager
import com.example.domain.pager.UpComingPagingMovies
import com.example.paging.pager.PopularMoviesImpl
import com.example.paging.pager.PopularTvShowsImpl
import com.example.paging.pager.TopRatedMovieImpl
import com.example.paging.pager.TopRatedTvShowsImpl
import com.example.paging.pager.TvShowsAiringTodayImpl
import com.example.paging.pager.TvShowsOnTheAirImpl
import com.example.paging.pager.UpComingMovieImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PagingModule {
    @Binds
    fun bindPopularMoviesPager(popularMovies: PopularMoviesImpl): PopularMoviesPager

    @Binds
    fun bindTopRatedMoviesPager(topRatedPagedMovies:TopRatedMovieImpl): TopRatedMoviesPager

    @Binds
    fun bindTopRatedTvShowsPager(topRatedTvShows: TopRatedTvShowsImpl): ToPRatedTvShowsPager

    @Binds
    fun bindUpComingMoviesPager(upComingMovieImpl: UpComingMovieImpl): UpComingPagingMovies

    @Binds
    fun bindTvShowsAiringTodayPager(tvShowsAiringTodayImpl: TvShowsAiringTodayImpl): TvShowsAiringTodayPager

    @Binds
    fun bindTvShowsOnTheAirPager(tvShowsOnTheAirImpl: TvShowsOnTheAirImpl): TvShowsOnTheAirPager

    @Binds
    fun bindPopularTvShowsPager(popularTvShowsImpl: PopularTvShowsImpl): PopularTvShowsPager
}
