package com.example.cinemaxv3.viewmodels.movieTrailerViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.use_cases.movietrailer_usecase.MovieTrailerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MovieTrailerViewModel @Inject constructor(private val trailerUseCase: MovieTrailerUseCase) : ViewModel(){
    fun getMovieTrailer(id: Int) = liveData(Dispatchers.IO) {
        val url = trailerUseCase(id = id)
        emit(url)
    }
}