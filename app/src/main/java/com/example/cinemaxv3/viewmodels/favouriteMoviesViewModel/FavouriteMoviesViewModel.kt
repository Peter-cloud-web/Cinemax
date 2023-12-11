package com.example.cinemaxv3.viewmodels.favouriteMoviesViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.example.domain.repository.RemoteMoviesRepository
import com.example.domain.entities.model.favourites.FavouriteMovies
import com.example.domain.repository.CachedMoviesRepository
import com.example.domain.use_cases.favouritemovies_usecase.GetFavouriteMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class FavouriteMoviesViewModel @Inject constructor(
    private val favouriteMovieUseCase: GetFavouriteMovieUseCase,
    private val repository: CachedMoviesRepository
) : ViewModel() {

    private val _favouriteMovies = MutableStateFlow(FavouriteMoviesUiStates())
    val favouriteMovies = _favouriteMovies.asStateFlow()

    init {
        getFavouriteMovies()
    }

    fun getFavouriteMovies() {
        try {
            _favouriteMovies.value = FavouriteMoviesUiStates(isLoading = true)
            val data = favouriteMovieUseCase()
            _favouriteMovies.value = data?.let { FavouriteMoviesUiStates(favouriteMovies = it) }!!
        } catch (e: Exception) {
            _favouriteMovies.value = FavouriteMoviesUiStates(
                error = handleFavouriteMoviesErrors(e))
        }
    }

    private fun handleFavouriteMoviesErrors(e:Exception):String{
        return  when (e) {
            is IOException -> "An unexpected error occurred: Please check Network/Internet settings"
            is HttpException -> "Unexpected network error occurred"
            else -> "An unexpected error occurred"
        }
    }

    fun saveFavouriteMovies(favouriteMovies: FavouriteMovies) = viewModelScope.launch {
        repository.insertFavouriteMovies(favouriteMovies)
    }
    
    fun deleteFavouriteMovie(id:Int){
        viewModelScope.launch { 
            repository.deleteFavouriteMovie(id)
        }
    }

}
