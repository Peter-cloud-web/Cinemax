package com.example.cinemaxv3.domain.use_cases.searchedMovies_usecase

import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.data.remote.dto.movieDto.MovieResponseDto
import com.example.cinemaxv3.data.remote.mappers.Mappers.toMovie
import com.example.cinemaxv3.domain.repository.MovieRepository
import com.example.cinemaxv3.models.Movie
import com.example.cinemaxv3.models.TopRatedMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(query: String) = repository.getSearchedMovies(query = query,page = 1)

}