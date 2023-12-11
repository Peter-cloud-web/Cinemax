package com.example.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.db.MovieDatabase
import com.example.domain.pager.TopRatedMoviesPager
import com.example.domain.repository.RemoteMoviesRepository
import com.example.paging.mediators.TopRatedMoviesMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedMovieImpl @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val repository: RemoteMoviesRepository
) :
    TopRatedMoviesPager {
    override fun getTopRatedMovies(): Flow<PagingData<TopRatedMovies>> {
        @OptIn(ExperimentalPagingApi::class) val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                movieDatabase.getTopRatedMoviesDao().getTopRatedMovies()
            }, remoteMediator = TopRatedMoviesMediator(movieDatabase, repository)
        ).flow
        return pager
    }
}