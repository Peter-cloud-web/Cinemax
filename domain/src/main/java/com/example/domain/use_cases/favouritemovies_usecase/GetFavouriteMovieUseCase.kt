package com.example.domain.use_cases.favouritemovies_usecase


import com.example.domain.MovieRepository
import com.example.framework.model.favourites.FavouriteMovies
import javax.inject.Inject

class GetFavouriteMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<List<FavouriteMovies>> =
        repository.getFavouriteMovies()

}