package com.example.cinemaxv3.paging.mediators

import androidx.paging.*
import androidx.room.withTransaction
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.service.MovieApi
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PopularMoviesRemoteMediator @Inject constructor(
    private val query: String,
    private val api: MovieApi,
    private val db: MovieDatabase
) : RemoteMediator<Int, Movie>() {
    val movieDao = db.getMovieDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    lastItem.id
                }
            }
            val response = loadKey?.let { api.getPopularMovies(MovieApi.api_key, it) }
            db.withTransaction {
                if (response != null) {
                    movieDao.insertPopularMovies(response.movies)
                }
            }
            MediatorResult.Success(
                endOfPaginationReached = true
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)

        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}
