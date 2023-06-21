package com.example.cinemaxv3.domain.use_cases.top_rated_movies_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.data.remote.dto.movieDto.TopRatedMovieResponseDto
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.paging.mediators.TopRatedMoviesMediator
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.models.TopRatedMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class TopRatedMoviesUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val movieDatabase: MovieDatabase
) {
    operator fun invoke():Flow<PagingData<TopRatedMovies>> {
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
                movieDatabase,repository
            )
        ).flow
        return pager
    }

}