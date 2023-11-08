package com.example.cinemaxv3.view.ui.viewmodels.favouriteMoviesViewModel;

import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.domain.use_cases.favouritemovies_usecase.DeleteMovieUseCase;
import com.example.framework.repository.MovieRepository;
import com.example.framework.model.favourites.FavouriteMovies;
import com.example.domain.use_cases.favouritemovies_usecase.GetFavouriteMovieUseCase;
import com.example.domain.use_cases.favouritemovies_usecase.InsertFavouriteMoviesUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u000e\u001a\u00020\u0011J\u0014\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u001bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/favouriteMoviesViewModel/FavouriteMoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "favouriteMovieUseCase", "Lcom/example/domain/use_cases/favouritemovies_usecase/GetFavouriteMovieUseCase;", "insertFavouriteMoviesUseCase", "Lcom/example/domain/use_cases/favouritemovies_usecase/InsertFavouriteMoviesUseCase;", "deleteMovieUseCase", "Lcom/example/domain/use_cases/favouritemovies_usecase/DeleteMovieUseCase;", "(Lcom/example/domain/use_cases/favouritemovies_usecase/GetFavouriteMovieUseCase;Lcom/example/domain/use_cases/favouritemovies_usecase/InsertFavouriteMoviesUseCase;Lcom/example/domain/use_cases/favouritemovies_usecase/DeleteMovieUseCase;)V", "_favouriteMovies", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/favouriteMoviesViewModel/FavouriteMoviesUiStates;", "favouriteMovies", "Lkotlinx/coroutines/flow/StateFlow;", "getFavouriteMovies", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteFavouriteMovie", "", "id", "", "handleFavouriteMoviesErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "saveFavouriteMovies", "Lkotlinx/coroutines/Job;", "Lcom/example/framework/model/favourites/FavouriteMovies;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FavouriteMoviesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.favouritemovies_usecase.GetFavouriteMovieUseCase favouriteMovieUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.favouritemovies_usecase.InsertFavouriteMoviesUseCase insertFavouriteMoviesUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.favouritemovies_usecase.DeleteMovieUseCase deleteMovieUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cinemaxv3.view.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesUiStates> _favouriteMovies = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesUiStates> favouriteMovies = null;
    
    @javax.inject.Inject
    public FavouriteMoviesViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.favouritemovies_usecase.GetFavouriteMovieUseCase favouriteMovieUseCase, @org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.favouritemovies_usecase.InsertFavouriteMoviesUseCase insertFavouriteMoviesUseCase, @org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.favouritemovies_usecase.DeleteMovieUseCase deleteMovieUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesUiStates> getFavouriteMovies() {
        return null;
    }
    
    public final void getFavouriteMovies() {
    }
    
    private final java.lang.String handleFavouriteMoviesErrors(java.lang.Exception e) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveFavouriteMovies(@org.jetbrains.annotations.NotNull
    com.example.framework.model.favourites.FavouriteMovies favouriteMovies) {
        return null;
    }
    
    public final void deleteFavouriteMovie(int id) {
    }
}