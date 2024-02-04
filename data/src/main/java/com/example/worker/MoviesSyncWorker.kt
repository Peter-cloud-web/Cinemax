package com.example.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.paging.ExperimentalPagingApi
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.paging.mediators.PopularMoviesMediator
import javax.inject.Inject

@HiltWorker
class MoviesSyncWorker @Inject constructor(
    appContext: Context,
    workerParams: WorkerParameters,
    private val popularMoviesMediator: PopularMoviesMediator
) : CoroutineWorker(appContext, workerParams) {
    @OptIn(ExperimentalPagingApi::class)
    override suspend fun doWork(): Result {
        try {
            popularMoviesMediator.initialize()
            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }
    }
}