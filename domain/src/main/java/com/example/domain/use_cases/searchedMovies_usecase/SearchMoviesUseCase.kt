package com.example.domain.use_cases.searchedMovies_usecase

import com.example.domain.repository.RemoteMoviesRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val repository: RemoteMoviesRepository) {
    suspend operator fun invoke(query: String) =
        repository.getSearchedMovies(query = query, page = 1)

}