package com.example.cinemaxv3.data.repository

import androidx.lifecycle.LiveData
import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.data.remote.dto.movieDto.MovieResponseDto
import com.example.cinemaxv3.data.remote.dto.movieDto.TopRatedMovieResponseDto
import com.example.cinemaxv3.data.remote.dto.movieDto.UpComingMovieResponseDto
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.model.favourites.FavouriteMovies
import com.example.cinemaxv3.domain.model.movieCasts.MovieCastsResponse
import com.example.cinemaxv3.domain.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.cinemaxv3.domain.model.trailersResponse.MovieTrailerResponse
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.cinemaxv3.service.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi, private val db: MovieDatabase
) : MovieRepository {

    override suspend fun getTopRatedMovies(page: Int): Resource<TopRatedMovieResponseDto> {
        return try {
            Resource.Loading(null)
            val response = api.getTopRatedMovies(page = page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (
            e: IOException
        ) {

            Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }


    override suspend fun getPopularMovies(page: Int): Resource<MovieResponseDto> {
        return try {
            Resource.Loading(null)
            val response = api.getPopularMovies(page = page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getUpComingMovies(page: Int): Resource<UpComingMovieResponseDto> {
        return try {
            Resource.Loading(null)
            val response = api.upComingMovies(page = page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }

    }

    override suspend fun getMovieReviews(id: Int): Resource<ReviewsResponse> {
        return try {
            Resource.Loading(null)
            val response = api.getMovieReviews(id)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
                Resource.Error(
                    e.localizedMessage ?: "Network/Server error. Check internet connection"
                )
        }
    }

    override suspend fun getTopRatedTvShows(page: Int): Resource<TvShowsResponses> {
        return try {
            Resource.Loading(null)
            val response = api.getTopRatedTvShows(page = page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }

    }

    override suspend fun getPopularTvShows(page: Int): Resource<TvShowsResponses> {
        return try {
            Resource.Loading(null)
            val response = api.getPopularTvShows(page = page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            Resource.Error(e.localizedMessage ?: "Network/Server error. Check internet connection")
        }
    }


    override suspend fun getTvShowsAiringToday(page: Int): Resource<TvShowsResponses> {
        return try {
            Resource.Loading(null)
            val response = api.getTvShowsAiringToday(page = page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
                Resource.Error(
                    e.localizedMessage ?: "Network/Server error. Check internet connection"
                )
        }
    }

    override suspend fun getTvShowsOnTheAir(page: Int): Resource<TvShowsResponses>{
        return try {
            Resource.Loading(null)
            val response = api.getTvShowsOnTheAir(page = page)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
                Resource.Error(
                    e.localizedMessage ?: "Network/Server error. Check internet connection"
                )
        }
    }

    override suspend fun getMovieTrailers(id: Int): Resource<MovieTrailerResponse> {
        return try {
            Resource.Loading(null)
            val response = api.getMovieTrailer(id)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
                Resource.Error(
                    e.localizedMessage ?: "Network/Server error. Check internet connection"
                )
        }
    }

    override suspend fun getMovieCasts(id: Int): Resource<MovieCastsResponse>{
        return try {
            Resource.Loading(null)
            val response = api.getMovieCasts(id)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
                Resource.Error(
                    e.localizedMessage ?: "Network/Server error. Check internet connection"
                )
        }
    }

    override suspend fun getSimilarMovies(id: Int): Resource<SimilarMoviesResponse> {
        return try {
            Resource.Loading(null)
            val response = api.getSimilarMovies(id)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
                Resource.Error(
                    e.localizedMessage ?: "Network/Server error. Check internet connection"
                )
        }
    }

    override suspend fun getSearchedMovies(query: String,page: Int): Resource<MovieResponseDto>{
        return try {
            Resource.Loading(null)
            val response = api.searchMovies(query = query, page = 1)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
                Resource.Error(
                    e.localizedMessage ?: "Network/Server error. Check internet connection"
                )
        }
    }

    override fun getFavouriteMovies() = db.getFavouriteMoviesDao().getAllFavouriteMovies()

    override suspend fun insertFavouriteMovies(favouriteMovies: FavouriteMovies) {
        db.getFavouriteMoviesDao().insertFavouriteMovies(favouriteMovies)
    }
}