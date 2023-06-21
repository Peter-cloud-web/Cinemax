package com.example.cinemaxv3.domain.use_cases.popularMovies_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.paging.mediators.PopularMoviesMediator
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.models.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(private val repository: MovieRepository, private val movieDatabase: MovieDatabase) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<Movie>> {
        val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                movieDatabase.getMovieDao().getPopularMovies()
            },
            remoteMediator = PopularMoviesMediator(
                movieDatabase, repository
            )
        ).flow
        return pager
    }
}




