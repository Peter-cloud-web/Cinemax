package com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel;

import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.cinemaxv3.models.Movie;
import com.example.data.paging.pagingSource.popularMovies_usecase.PopularMoviesUseCase;
import com.example.framework.repository.MovieRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularMoviesViewModel/PopularMoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "getPopularMoviesUseCase", "Lcom/example/data/paging/pagingSource/popularMovies_usecase/PopularMoviesUseCase;", "repository", "Lcom/example/framework/repository/MovieRepository;", "(Lcom/example/data/paging/pagingSource/popularMovies_usecase/PopularMoviesUseCase;Lcom/example/framework/repository/MovieRepository;)V", "_popularMovieStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularMoviesViewModel/UiStates;", "Lcom/example/cinemaxv3/models/Movie;", "popularMoviesUiState", "Lkotlinx/coroutines/flow/StateFlow;", "getPopularMoviesUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getPopularMovies", "", "getTopRatedMovie", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePopularMoviesErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PopularMoviesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.paging.pagingSource.popularMovies_usecase.PopularMoviesUseCase getPopularMoviesUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.framework.repository.MovieRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel.UiStates<com.example.cinemaxv3.models.Movie>> _popularMovieStates = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel.UiStates<com.example.cinemaxv3.models.Movie>> popularMoviesUiState = null;
    
    @javax.inject.Inject
    public PopularMoviesViewModel(@org.jetbrains.annotations.NotNull
    com.example.data.paging.pagingSource.popularMovies_usecase.PopularMoviesUseCase getPopularMoviesUseCase, @org.jetbrains.annotations.NotNull
    com.example.framework.repository.MovieRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel.UiStates<com.example.cinemaxv3.models.Movie>> getPopularMoviesUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTopRatedMovie(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.cinemaxv3.models.Movie>> $completion) {
        return null;
    }
    
    public final void getPopularMovies() {
    }
    
    private final java.lang.String handlePopularMoviesErrors(java.lang.Exception e) {
        return null;
    }
}