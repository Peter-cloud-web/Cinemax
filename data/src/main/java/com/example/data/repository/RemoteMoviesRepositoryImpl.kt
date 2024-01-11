package com.example.data.repository

import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.data.MovieApi
import com.example.domain.common.Resource
import com.example.domain.entities.model.movieCasts.MovieCastsResponse
import com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.domain.entities.model.trailersResponse.MovieTrailerResponse
import com.example.domain.entities.model.tvShowsResponse.TvShowsResponses
import com.example.domain.movieDto.MovieResponseDto
import com.example.domain.movieDto.TopRatedMovieResponseDto
import com.example.domain.movieDto.UpComingMovieResponseDto
import com.example.domain.repository.RemoteMoviesRepository
import javax.inject.Inject


class RemoteMoviesRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : RemoteMoviesRepository {

    override suspend fun getTopRatedMovies(page: Int): Resource<TopRatedMovieResponseDto> {
        return movieApi.getTopRatedMovies(page)
    }

    override suspend fun getPopularMovies(page: Int): Resource<MovieResponseDto> {
        return movieApi.getPopularMovies(page)
    }

    override suspend fun getUpComingMovies(page: Int): Resource<UpComingMovieResponseDto> {
        return movieApi.getUpComingMovies(page)
    }

    override suspend fun getMovieReviews(id: Int): Resource<ReviewsResponse> {
        return movieApi.getMovieReviews(id)
    }

    override suspend fun getTopRatedTvShows(page: Int): Resource<TvShowsResponses> {
        return movieApi.getTopRatedTvShows(page)
    }

    override suspend fun getPopularTvShows(page: Int): Resource<TvShowsResponses> {
        return movieApi.getPopularTvShows(page)
    }


    override suspend fun getTvShowsAiringToday(page: Int): Resource<TvShowsResponses> {
        return movieApi.getTvShowsAiringToday(page)
    }

    override suspend fun getTvShowsOnTheAir(page: Int): Resource<TvShowsResponses> {
        return movieApi.getTvShowsOnTheAir(page)
    }

    override suspend fun getMovieTrailers(id: Int): Resource<MovieTrailerResponse> {
       return movieApi.getMovieTrailers(id)
    }

    override suspend fun getMovieCasts(id: Int): Resource<MovieCastsResponse> {
        return movieApi.getMovieCasts(id)
    }

    override suspend fun getSimilarMovies(id: Int, page: Int): Resource<SimilarMoviesResponse> {
        return movieApi.getSimilarMovies(id,page)
    }

    override suspend fun getSearchedMovies(
        query: String,
        page: Int
    ): Resource<MovieResponseDto> {
        return movieApi.getSearchedMovies(query,page)
    }
}