package com.example.cinemaxv3.domain.use_cases.movietrailer_usecase

import com.example.cinemaxv3.common.Resource
import com.example.cinemaxv3.domain.model.trailersResponse.MovieTrailerResponse
import com.example.cinemaxv3.domain.repository.MovieRepository
import hilt_aggregated_deps._dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieTrailerUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int) =
        repository.getMovieTrailers(id = id)
}