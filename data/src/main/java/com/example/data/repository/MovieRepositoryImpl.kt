package com.example.data.repository

import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.data.BuildConfig
import com.example.db.MovieDatabase
import com.example.framework.common.Resource
import com.example.framework.model.favourites.FavouriteMovies
import com.example.framework.model.movieCasts.MovieCastsResponse
import com.example.framework.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.framework.model.trailersResponse.MovieTrailerResponse
import com.example.framework.model.tvShowsResponse.TvShowsResponses
import com.example.framework.movieDto.MovieResponseDto
import com.example.framework.movieDto.TopRatedMovieResponseDto
import com.example.framework.movieDto.UpComingMovieResponseDto
import com.example.framework.repository.MovieRepository
import com.example.service.MovieApi
import com.example.util.Constants.KTOR_BASE_URL
import com.example.util.Constants.POPULAR_MOVIES
import com.example.util.Constants.POPULAR_TV_SHOWS
import com.example.util.Constants.SEARCH_MOVIES
import com.example.util.Constants.TOPRATED_MOVIES
import com.example.util.Constants.TOPRATED_TV_SHOWS
import com.example.util.Constants.TV_SHOWS_AIRING_TODAY
import com.example.util.Constants.TV_SHOWS_ON_THE_AIR
import com.example.util.Constants.UPCOMING_MOVIES
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import java.io.IOException
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient, private val api: MovieApi, private val db: MovieDatabase
) : MovieRepository {

    private suspend inline fun <reified T> getApiRequest(urlPath: String, page: Int): Resource<T> {
        return try {
            Resource.Loading(null)
            val response = httpClient.get<T> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = KTOR_BASE_URL
                    encodedPath = urlPath
                    parameters.append("api_key", BuildConfig.MOVIE_API_KEY)
                    parameters.append("page", page.toString())
                }
            }
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: " An unexpected error. Try again later.")
        } catch (e: IOException) {
            Resource.Error("Network/Server error. Check internet connection")
        }
    }

    override suspend fun getTopRatedMovies(page: Int): Resource<TopRatedMovieResponseDto> {
        return getApiRequest(TOPRATED_MOVIES, page)
    }

    override suspend fun getPopularMovies(page: Int): Resource<MovieResponseDto> {
        return getApiRequest(POPULAR_MOVIES, page)
    }

    override suspend fun getUpComingMovies(page: Int): Resource<UpComingMovieResponseDto> {
        return getApiRequest(UPCOMING_MOVIES, page)
    }

    override suspend fun getMovieReviews(id: Int): Resource<ReviewsResponse> {
        return getApiRequest("/3/movie/${id}/reviews", 1)
    }

    override suspend fun getTopRatedTvShows(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(TOPRATED_TV_SHOWS, page)
    }

    override suspend fun getPopularTvShows(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(POPULAR_TV_SHOWS, page)
    }


    override suspend fun getTvShowsAiringToday(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(TV_SHOWS_AIRING_TODAY, page)
    }

    override suspend fun getTvShowsOnTheAir(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(TV_SHOWS_ON_THE_AIR, page)
    }

    override suspend fun getMovieTrailers(id: Int): Resource<MovieTrailerResponse> {

        return try {
            Resource.Loading(null)
            val response = httpClient.get<MovieTrailerResponse> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = KTOR_BASE_URL
                    encodedPath = "/3/movie/${id}/videos"
                    parameters.append("api_key", BuildConfig.MOVIE_API_KEY)
                    parameters.append("language", "en-US")
                }
            }
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(
                e.localizedMessage ?: " An unexpected error. Try again later."
            )
        } catch (e: IOException) {
            Resource.Error(
                e.localizedMessage ?: "Network/Server error. Check internet connection"
            )
        }
    }

    override suspend fun getMovieCasts(id: Int): Resource<MovieCastsResponse> {
        return getApiRequest("/3/movie/${id}/credits", 1)
    }

    override suspend fun getSimilarMovies(id: Int, page: Int): Resource<SimilarMoviesResponse> {
        return getApiRequest("/3/movie/$id/similar", page)
    }

    override suspend fun getSearchedMovies(
        query: String,
        page: Int
    ): Resource<MovieResponseDto> {
//        return getApiRequest("/3/search/movie${query}", page)
        return try {
            Resource.Loading(null)
            val response = httpClient.get<MovieResponseDto> {
                url {
                    protocol = URLProtocol.HTTPS
                    host = KTOR_BASE_URL
                    encodedPath = SEARCH_MOVIES
                    parameters.append("api_key", BuildConfig.MOVIE_API_KEY)
                    parameters.append("language", "en-US")
                    parameters.append("query", query)
                    parameters.append("page", page.toString())
                }
            }
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(
                e.localizedMessage ?: " An unexpected error. Try again later."
            )
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