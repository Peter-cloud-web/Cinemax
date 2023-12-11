package com.example.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.models.UpComingMovies
import com.example.db.MovieDatabase
import com.example.domain.pager.UpComingPagingMovies
import com.example.domain.repository.RemoteMoviesRepository
import com.example.paging.mediators.UpComingMoviesMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpComingMovieImpl @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val repository: RemoteMoviesRepository
) :
    UpComingPagingMovies {
    override fun getUpComingMovies(): Flow<PagingData<UpComingMovies>> {
        @OptIn(ExperimentalPagingApi::class) val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                movieDatabase.getUpComingMoviesDao().getUpComingMovies()
            }, remoteMediator = UpComingMoviesMediator(movieDatabase, repository)
        ).flow
        return pager
    }
}