package com.example.data

import com.example.cinemaxv3.models.responses.ReviewsResponse
import com.example.domain.common.Resource
import com.example.domain.entities.model.movieCasts.MovieCastsResponse
import com.example.domain.entities.model.similarMoviesResponse.SimilarMoviesResponse
import com.example.domain.entities.model.trailersResponse.MovieTrailerResponse
import com.example.domain.entities.model.tvShowsResponse.TvShowsResponses
import com.example.domain.movieDto.MovieResponseDto
import com.example.domain.movieDto.TopRatedMovieResponseDto
import com.example.domain.movieDto.UpComingMovieResponseDto
import com.example.util.Constants
import com.example.util.Constants.KTOR_BASE_URL
import com.example.util.Constants.SEARCH_MOVIES
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import java.io.IOException
import javax.inject.Inject

class MovieApi @Inject constructor(private val httpClient: HttpClient) {
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

    suspend fun getTopRatedMovies(page: Int): Resource<TopRatedMovieResponseDto> {
        return getApiRequest(Constants.TOPRATED_MOVIES, page)
    }

    suspend fun getPopularMovies(page: Int): Resource<MovieResponseDto> {
        return getApiRequest(Constants.POPULAR_MOVIES, page)
    }

    suspend fun getUpComingMovies(page: Int): Resource<UpComingMovieResponseDto> {
        return getApiRequest(Constants.UPCOMING_MOVIES, page)
    }

    suspend fun getMovieReviews(id: Int): Resource<ReviewsResponse> {
        return getApiRequest("/3/movie/${id}/reviews", 1)
    }

    suspend fun getTopRatedTvShows(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(Constants.TOPRATED_TV_SHOWS, page)
    }

    suspend fun getPopularTvShows(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(Constants.POPULAR_TV_SHOWS, page)
    }


    suspend fun getTvShowsAiringToday(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(Constants.TV_SHOWS_AIRING_TODAY, page)
    }

    suspend fun getTvShowsOnTheAir(page: Int): Resource<TvShowsResponses> {
        return getApiRequest(Constants.TV_SHOWS_ON_THE_AIR, page)
    }

    suspend fun getMovieTrailers(id: Int): Resource<MovieTrailerResponse> {

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

    suspend fun getMovieCasts(id: Int): Resource<MovieCastsResponse> {
        return getApiRequest("/3/movie/${id}/credits", 1)
    }

    suspend fun getSimilarMovies(id: Int, page: Int): Resource<SimilarMoviesResponse> {
        return getApiRequest("/3/movie/$id/similar", page)
    }

    suspend fun getSearchedMovies(
        query: String,
        page: Int
    ): Resource<MovieResponseDto> {
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
}