package com.example.cinemaxv3.presentation.ui.viewmodels.movieReviewsViewModel

import com.example.cinemaxv3.models.responses.Review
import com.example.framework.model.similarMoviesResponse.SimilarMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieReviewsUiStates (
    val isLoading: Boolean = false,
    val reviews : Flow<Review> = emptyFlow(),
    val error:String = ""

)