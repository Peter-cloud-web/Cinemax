package com.example.cinemaxv3.view.ui.viewmodels.movieTrailerViewModel;

import androidx.lifecycle.ViewModel;
import com.example.domain.use_cases.movietrailer_usecase.MovieTrailerUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieTrailerViewModel/MovieTrailerViewModel;", "Landroidx/lifecycle/ViewModel;", "trailerUseCase", "Lcom/example/domain/use_cases/movietrailer_usecase/MovieTrailerUseCase;", "(Lcom/example/domain/use_cases/movietrailer_usecase/MovieTrailerUseCase;)V", "getMovieTrailer", "Landroidx/lifecycle/LiveData;", "Lcom/example/framework/common/Resource;", "Lcom/example/framework/model/trailersResponse/MovieTrailerResponse;", "id", "", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieTrailerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.movietrailer_usecase.MovieTrailerUseCase trailerUseCase = null;
    
    @javax.inject.Inject
    public MovieTrailerViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.movietrailer_usecase.MovieTrailerUseCase trailerUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.framework.common.Resource<com.example.framework.model.trailersResponse.MovieTrailerResponse>> getMovieTrailer(int id) {
        return null;
    }
}