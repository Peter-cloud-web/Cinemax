package com.example.domain.use_cases.searchedMovies_usecase

import com.example.domain.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(query: String) =
        repository.getSearchedMovies(query = query, page = 1)

}