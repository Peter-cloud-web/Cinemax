package com.example.domain.repository


import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.domain.entities.model.favourites.FavouriteMovies
import com.example.domain.entities.model.movieCasts.MovieCastsResponse
import com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.domain.entities.model.trailersResponse.MovieTrailerResponse
import com.example.domain.entities.model.tvShowsResponse.TvShowsResponses
import com.example.domain.common.Resource
import com.example.domain.movieDto.MovieResponseDto
import com.example.domain.movieDto.TopRatedMovieResponseDto
import com.example.domain.movieDto.UpComingMovieResponseDto
import kotlinx.coroutines.flow.Flow

interface RemoteMoviesRepository {
    suspend fun getTopRatedMovies(page: Int): Resource<TopRatedMovieResponseDto>

    suspend fun getPopularMovies(page: Int): Resource<MovieResponseDto>

    suspend fun getUpComingMovies(page: Int): Resource<UpComingMovieResponseDto>

    suspend fun getMovieReviews(movieId: Int): Resource<ReviewsResponse>

    suspend fun getTopRatedTvShows(page: Int): Resource<TvShowsResponses>

    suspend fun getPopularTvShows(page: Int): Resource<TvShowsResponses>

    suspend fun getTvShowsAiringToday(page: Int): Resource<TvShowsResponses>

    suspend fun getTvShowsOnTheAir(page: Int): Resource<TvShowsResponses>

    suspend fun getMovieTrailers(id: Int): Resource<MovieTrailerResponse>

    suspend fun getMovieCasts(id: Int): Resource<MovieCastsResponse>

    suspend fun getSimilarMovies(
        id: Int,
        page: Int
    ): Resource<SimilarMoviesResponse>

    suspend fun getSearchedMovies(
        query: String,
        page: Int
    ): Resource<MovieResponseDto>
}