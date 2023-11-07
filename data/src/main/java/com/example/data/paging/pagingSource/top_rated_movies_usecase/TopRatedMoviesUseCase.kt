package com.example.data.paging.pagingSource.top_rated_movies_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.db.MovieDatabase
import com.example.domain.MovieRepository
import com.example.data.paging.mediators.TopRatedMoviesMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedMoviesUseCase @Inject constructor(
    private val repository: com.example.domain.MovieRepository,
    private val movieDatabase: MovieDatabase
) {
    operator fun invoke(): Flow<PagingData<TopRatedMovies>> {
        @OptIn(ExperimentalPagingApi::class)
        val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                movieDatabase.getTopRatedMoviesDao().getTopRatedMovies()
            },
            remoteMediator = TopRatedMoviesMediator(
                movieDatabase, repository
            )
        ).flow
        return pager
    }

}