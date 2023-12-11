package com.example.paging.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.models.Movie
import com.example.db.MovieDatabase
import com.example.domain.pager.PopularMoviesPager
import com.example.domain.repository.RemoteMoviesRepository
import com.example.paging.mediators.PopularMoviesMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMoviesImpl @Inject constructor(
    private val movieDatabase: MovieDatabase,
    private val repository: RemoteMoviesRepository
) : PopularMoviesPager {
    override fun getPopularMovies(): Flow<PagingData<Movie>> {
        @OptIn(ExperimentalPagingApi::class) val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                movieDatabase.getMovieDao().getPopularMovies()
            }, remoteMediator = PopularMoviesMediator(movieDatabase, repository)
        ).flow
        return pager
    }
}