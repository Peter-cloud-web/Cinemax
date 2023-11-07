package com.example.domain

import com.example.cinemaxv3.models.MovieResponse
import com.example.cinemaxv3.models.TopratedMovieResponse
import com.example.cinemaxv3.models.UpcomingMovieResponse
import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.framework.common.Resource
import com.example.framework.model.favourites.FavouriteMovies
import com.example.framework.model.movieCasts.MovieCastsResponse
import com.example.framework.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.framework.model.trailersResponse.MovieTrailerResponse
import com.example.framework.model.tvShowsResponse.TvShowsResponses
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getTopRatedMovies(page: Int): com.example.framework.common.Resource<TopratedMovieResponse>

    suspend fun getPopularMovies(page: Int): com.example.framework.common.Resource<MovieResponse>

    suspend fun getUpComingMovies(page: Int): com.example.framework.common.Resource<UpcomingMovieResponse>

    suspend fun getMovieReviews(movieId: Int): com.example.framework.common.Resource<ReviewsResponse>

    suspend fun getTopRatedTvShows(page: Int): com.example.framework.common.Resource<com.example.framework.model.tvShowsResponse.TvShowsResponses>

    suspend fun getPopularTvShows(page: Int): com.example.framework.common.Resource<com.example.framework.model.tvShowsResponse.TvShowsResponses>

    suspend fun getTvShowsAiringToday(page: Int): com.example.framework.common.Resource<com.example.framework.model.tvShowsResponse.TvShowsResponses>

    suspend fun getTvShowsOnTheAir(page: Int): com.example.framework.common.Resource<com.example.framework.model.tvShowsResponse.TvShowsResponses>

    suspend fun getMovieTrailers(id: Int): com.example.framework.common.Resource<com.example.framework.model.trailersResponse.MovieTrailerResponse>

    suspend fun getMovieCasts(id: Int): com.example.framework.common.Resource<com.example.framework.model.movieCasts.MovieCastsResponse>

    suspend fun getSimilarMovies(id: Int, page: Int): com.example.framework.common.Resource<com.example.framework.model.similarMoviesResponse.SimilarMoviesResponse>

    suspend fun getSearchedMovies(
        query: String,
        page: Int
    ): com.example.framework.common.Resource<MovieResponse>

    fun getFavouriteMovies(): Flow<List<com.example.framework.model.favourites.FavouriteMovies>>

    suspend fun insertFavouriteMovies(favouriteMovies: com.example.framework.model.favourites.FavouriteMovies)

    suspend fun deleteFavouriteMovie(id: Int)

}