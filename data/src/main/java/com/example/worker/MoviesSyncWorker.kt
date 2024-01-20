package com.example.worker

import Mappers.toMovie
import android.content.Context
import android.util.Log
import androidx.paging.LoadState
import androidx.room.withTransaction
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkerParameters
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.db.MovieDatabase
import com.example.domain.repository.RemoteMoviesRepository
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MoviesSyncWorker @Inject constructor(
    appContext: Context,
    workerParams: WorkerParameters,
    private val repository: RemoteMoviesRepository,
    private val db: MovieDatabase
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        Log.d("MoviesSyncWorker", "Work started")
        val page = inputData.getInt(KEY_PAGE, 1)
        try {
            val apiResponse = repository.getPopularMovies(page = page)
            val movies = apiResponse.data?.results?.map { movieDto ->
                movieDto.toMovie()
            }
            db.withTransaction {
                db.getRemoteKeysDao().clearRemoteKeys()
                db.getMovieDao().clearAllMovies()
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (LoadState.Loading.endOfPaginationReached) null else page + 1
                val remoteKeys = movies?.map { movie ->
                    MovieRemoteKeys(
                        movieID = movie.id,
                        prevKey = prevKey,
                        currentPage = page,
                        nextKey = nextKey
                    )
                }
                remoteKeys?.let {
                    db.getRemoteKeysDao().insertAllKeys(remoteKeys)
                }
                movies?.let { movieList ->
                    db.getMovieDao()
                        .insertPopularMovies(movieList.onEachIndexed { _, movie ->
                            movie.page = page
                        })
                }
            }

        } catch (error: IOException) {
            return Result.failure()
        }
        Log.d("MoviesSyncWorker", "Work completed")
        return Result.success()
    }

    companion object {
        const val KEY_PAGE = "page"
    }

}