package com.example.cinemaxv3.view.ui.viewmodels.movieReviewsViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.domain.use_cases.movieReviews_usecase.MovieReviewUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieReviewsViewModel/MovieReviewsViewModel;", "Landroidx/lifecycle/ViewModel;", "movieReviewUseCase", "Lcom/example/domain/use_cases/movieReviews_usecase/MovieReviewUseCase;", "(Lcom/example/domain/use_cases/movieReviews_usecase/MovieReviewUseCase;)V", "_movieReviews", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieReviewsViewModel/MovieReviewsUiStates;", "movieReviews", "Landroidx/lifecycle/LiveData;", "getMovieReviews", "()Landroidx/lifecycle/LiveData;", "getReviews", "", "id", "", "handleMovieCastsErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieReviewsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.movieReviews_usecase.MovieReviewUseCase movieReviewUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.cinemaxv3.view.ui.viewmodels.movieReviewsViewModel.MovieReviewsUiStates> _movieReviews = null;
    
    @javax.inject.Inject
    public MovieReviewsViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.movieReviews_usecase.MovieReviewUseCase movieReviewUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.cinemaxv3.view.ui.viewmodels.movieReviewsViewModel.MovieReviewsUiStates> getMovieReviews() {
        return null;
    }
    
    public final void getReviews(int id) {
    }
    
    private final java.lang.String handleMovieCastsErrors(java.lang.Exception e) {
        return null;
    }
}