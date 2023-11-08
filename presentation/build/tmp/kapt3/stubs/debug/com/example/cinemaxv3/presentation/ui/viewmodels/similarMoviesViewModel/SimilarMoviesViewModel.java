package com.example.cinemaxv3.view.ui.viewmodels.similarMoviesViewModel;

import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.domain.use_cases.similarmovies_usecase.SimilarMovieUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/similarMoviesViewModel/SimilarMoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "similarMovieUseCase", "Lcom/example/domain/use_cases/similarmovies_usecase/SimilarMovieUseCase;", "(Lcom/example/domain/use_cases/similarmovies_usecase/SimilarMovieUseCase;)V", "_similarMovies", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/similarMoviesViewModel/SimilarMoviesUiState;", "similarMovies", "Lkotlinx/coroutines/flow/StateFlow;", "getSimilarMovies", "()Lkotlinx/coroutines/flow/StateFlow;", "", "id", "", "handleSearchMoviesErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SimilarMoviesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.similarmovies_usecase.SimilarMovieUseCase similarMovieUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cinemaxv3.view.ui.viewmodels.similarMoviesViewModel.SimilarMoviesUiState> _similarMovies = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.similarMoviesViewModel.SimilarMoviesUiState> similarMovies = null;
    
    @javax.inject.Inject
    public SimilarMoviesViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.similarmovies_usecase.SimilarMovieUseCase similarMovieUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.similarMoviesViewModel.SimilarMoviesUiState> getSimilarMovies() {
        return null;
    }
    
    public final void getSimilarMovies(int id) {
    }
    
    private final java.lang.String handleSearchMoviesErrors(java.lang.Exception e) {
        return null;
    }
}