package com.example.domain.use_cases.top_rated_movies_usecase

import androidx.paging.PagingData
import com.example.cinemaxv3.models.TopRatedMovies
import com.example.domain.pager.TopRatedMoviesPager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedMoviesUseCase @Inject constructor(private val topRatedMoviesPager: TopRatedMoviesPager) {
    operator fun invoke(): Flow<PagingData<TopRatedMovies>> {
        val topRatedMovies = topRatedMoviesPager.getTopRatedMovies()
        return topRatedMovies
    }
}