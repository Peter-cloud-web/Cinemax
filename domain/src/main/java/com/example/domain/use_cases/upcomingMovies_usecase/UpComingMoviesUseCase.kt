package com.example.domain.use_cases.upcomingMovies_usecase

import androidx.paging.PagingData
import com.example.cinemaxv3.models.UpComingMovies
import com.example.domain.pager.UpComingPagingMovies

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpComingMoviesUseCase @Inject constructor(private val upComingPagingMovies: UpComingPagingMovies) {
    operator fun invoke(): Flow<PagingData<UpComingMovies>> {
        val UpComingMovies = upComingPagingMovies.getUpComingMovies()
        return UpComingMovies
    }
}

