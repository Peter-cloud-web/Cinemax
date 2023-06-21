package com.example.cinemaxv3.domain.use_cases.upcomingMovies_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.data.remote.dto.movieDto.UpComingMovieResponseDto
import com.example.cinemaxv3.db.MovieDatabase
import com.example.cinemaxv3.domain.model.tvShowsResponse.TvShowsResponses
import com.example.cinemaxv3.domain.paging.mediators.UpComingMoviesMediator
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.models.UpComingMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class UpComingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val movieDatabase: MovieDatabase
) {

    operator fun invoke():Flow<PagingData<UpComingMovies>> {
        @OptIn(ExperimentalPagingApi::class)
        val pager = Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                movieDatabase.getUpComingMoviesDao().getUpComingMovies()
            },
            remoteMediator = UpComingMoviesMediator(
                movieDatabase,
                repository

            )
        ).flow
return pager
    }
}