package com.example.domain.use_cases.popularMovies_usecase


import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.cinemaxv3.models.Movie
import com.example.domain.pager.PopularMoviesPager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularMoviesUseCase @Inject constructor(private val popularMoviesPager: PopularMoviesPager) {
    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(): Flow<PagingData<Movie>> {
        val popularMovies = popularMoviesPager.getPopularMovies()
        return popularMovies
    }
}




