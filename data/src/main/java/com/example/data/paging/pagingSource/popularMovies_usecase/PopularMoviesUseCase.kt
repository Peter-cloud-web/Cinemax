package com.example.data.paging.pagingSource.popularMovies_usecase


import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.models.Movie
import com.example.db.MovieDatabase
import com.example.domain.MovieRepository
import com.example.data.paging.mediators.PopularMoviesMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(
    private val repository: com.example.domain.MovieRepository,
    private val movieDatabase: MovieDatabase
) {

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




