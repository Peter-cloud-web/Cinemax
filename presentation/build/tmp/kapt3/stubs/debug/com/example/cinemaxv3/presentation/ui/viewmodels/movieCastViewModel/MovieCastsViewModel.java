package com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel;

import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.domain.use_cases.moviecasts_usecase.MovieCastsUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieCastViewModel/MovieCastsViewModel;", "Landroidx/lifecycle/ViewModel;", "getMovieCastsUseCase", "Lcom/example/domain/use_cases/moviecasts_usecase/MovieCastsUseCase;", "(Lcom/example/domain/use_cases/moviecasts_usecase/MovieCastsUseCase;)V", "_movieCastsResponse", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieCastViewModel/MovieCastsUiStates;", "movieCastResponse", "Lkotlinx/coroutines/flow/StateFlow;", "getMovieCastResponse", "()Lkotlinx/coroutines/flow/StateFlow;", "handleMovieCastsErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "movieCasts", "", "id", "", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieCastsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.moviecasts_usecase.MovieCastsUseCase getMovieCastsUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel.MovieCastsUiStates> _movieCastsResponse = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel.MovieCastsUiStates> movieCastResponse = null;
    
    @javax.inject.Inject
    public MovieCastsViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.moviecasts_usecase.MovieCastsUseCase getMovieCastsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.presentation.ui.viewmodels.movieCastViewModel.MovieCastsUiStates> getMovieCastResponse() {
        return null;
    }
    
    public final void movieCasts(int id) {
    }
    
    private final java.lang.String handleMovieCastsErrors(java.lang.Exception e) {
        return null;
    }
}