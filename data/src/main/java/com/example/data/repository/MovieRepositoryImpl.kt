package com.example.data.repository

import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.framework.common.Resource
import com.example.framework.model.favourites.FavouriteMovies
import com.example.framework.model.movieCasts.MovieCastsResponse
import com.example.framework.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.framework.model.trailersResponse.MovieTrailerResponse
import com.example.framework.model.tvShowsResponse.TvShowsResponses
import com.example.db.MovieDatabase
import com.example.framework.movieDto.TopRatedMovieResponseDto
import com.example.framework.repository.MovieRepository
import com.example.service.MovieApi
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi, private val db: MovieDatabase
) : MovieRepository {

    override suspend fun getTopRatedMovies(page: Int): Resource<TopRatedMovieResponseDto> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getTopRatedMovies(page = page)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (
            e: IOException
        ) {

            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }


    override suspend fun getPopularMovies(page: Int): com.example.framework.common.Resource<com.example.framework.movieDto.MovieResponseDto> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getPopularMovies(page = page)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getUpComingMovies(page: Int): com.example.framework.common.Resource<com.example.framework.movieDto.UpComingMovieResponseDto> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.upComingMovies(page = page)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }

    }

    override suspend fun getMovieReviews(id: Int): com.example.framework.common.Resource<ReviewsResponse> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getMovieReviews(id)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getTopRatedTvShows(page: Int): com.example.framework.common.Resource<TvShowsResponses> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getTopRatedTvShows(page = page)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }

    }

    override suspend fun getPopularTvShows(page: Int): com.example.framework.common.Resource<TvShowsResponses> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getPopularTvShows(page = page)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: "Network/Server error. Check internet connection")
        }
    }


    override suspend fun getTvShowsAiringToday(page: Int): com.example.framework.common.Resource<TvShowsResponses> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getTvShowsAiringToday(page = page)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getTvShowsOnTheAir(page: Int): com.example.framework.common.Resource<TvShowsResponses> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getTvShowsOnTheAir(page = page)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getMovieTrailers(id: Int): com.example.framework.common.Resource<MovieTrailerResponse> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getMovieTrailer(id)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getMovieCasts(id: Int): com.example.framework.common.Resource<MovieCastsResponse> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getMovieCasts(id)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getSimilarMovies(id: Int): com.example.framework.common.Resource<SimilarMoviesResponse> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.getSimilarMovies(id)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getSearchedMovies(query: String, page: Int): com.example.framework.common.Resource<com.example.framework.movieDto.MovieResponseDto> {
        return try {
            com.example.framework.common.Resource.Loading(null)
            val response = api.searchMovies(query = query, page = 1)
            com.example.framework.common.Resource.Success(response)
        } catch (e: Exception) {
            com.example.framework.common.Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            com.example.framework.common.Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override fun getFavouriteMovies() = db.getFavouriteMoviesDao().getAllFavouriteMovies()

    override suspend fun insertFavouriteMovies(favouriteMovies: FavouriteMovies) {
        db.getFavouriteMoviesDao().insertFavouriteMovies(favouriteMovies)
    }
}