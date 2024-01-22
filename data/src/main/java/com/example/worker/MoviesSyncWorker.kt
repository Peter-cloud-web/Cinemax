package com.example.worker

import Mappers.toMovie
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.paging.LoadState
import androidx.room.withTransaction
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.cinemaxv3.models.MovieRemoteKeys
import com.example.db.MovieDatabase
import com.example.domain.repository.RemoteMoviesRepository
import com.example.domain.use_cases.popularMovies_usecase.PopularMoviesUseCase
import dagger.hilt.android.migration.CustomInjection.inject
import java.io.IOException
import javax.inject.Inject

@HiltWorker
class MoviesSyncWorker @Inject constructor(
    appContext: Context,
    workerParams: WorkerParameters,
    private val popularMoviesUseCase: PopularMoviesUseCase

) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        Log.d("MoviesSyncWorker", "Work started")
        popularMoviesUseCase.invoke()
        Log.d("MoviesSyncWorker", "Work completed")
        return Result.success()
    }

    companion object {
        const val KEY_PAGE = "page"
    }

}