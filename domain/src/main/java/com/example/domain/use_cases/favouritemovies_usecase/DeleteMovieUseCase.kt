package com.example.domain.use_cases.favouritemovies_usecase

import com.example.domain.MovieRepository
import javax.inject.Inject

class DeleteMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(id: Int) {
        repository.deleteFavouriteMovie(id)
    }
}