package com.example.data.paging.pagingSource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.models.UpComingMovies
import com.example.db.MovieDatabase
import com.example.domain.MovieRepository
import com.example.data.paging.mediators.UpComingMoviesMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpComingMoviesUseCase @Inject constructor(
    private val repository: com.example.domain.MovieRepository, private val movieDatabase: MovieDatabase
) {

    operator fun invoke(): Flow<PagingData<UpComingMovies>> {
        @OptIn(ExperimentalPagingApi::class) val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                movieDatabase.getUpComingMoviesDao().getUpComingMovies()
            }, remoteMediator = UpComingMoviesMediator(
                movieDatabase, repository

            )
        ).flow
        return pager
    }
}