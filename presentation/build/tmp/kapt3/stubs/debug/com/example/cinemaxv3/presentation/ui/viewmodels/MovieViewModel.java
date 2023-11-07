package com.example.cinemaxv3.presentation.ui.viewmodels;

import androidx.lifecycle.ViewModel;
import com.example.framework.model.favourites.FavouriteMovies;
import com.example.framework.repository.MovieRepository;
import com.example.service.MovieApi;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/MovieViewModel;", "Landroidx/lifecycle/ViewModel;", "api", "Lcom/example/service/MovieApi;", "repository", "Lcom/example/framework/repository/MovieRepository;", "(Lcom/example/service/MovieApi;Lcom/example/framework/repository/MovieRepository;)V", "getApi", "()Lcom/example/service/MovieApi;", "getRepository", "()Lcom/example/framework/repository/MovieRepository;", "fetchFavouriteMovie", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/framework/model/favourites/FavouriteMovies;", "saveFavouriteMovie", "Lkotlinx/coroutines/Job;", "movie", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.service.MovieApi api = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.framework.repository.MovieRepository repository = null;
    
    @javax.inject.Inject
    public MovieViewModel(@org.jetbrains.annotations.NotNull
    com.example.service.MovieApi api, @org.jetbrains.annotations.NotNull
    com.example.framework.repository.MovieRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.service.MovieApi getApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.framework.repository.MovieRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job saveFavouriteMovie(@org.jetbrains.annotations.NotNull
    com.example.framework.model.favourites.FavouriteMovies movie) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.framework.model.favourites.FavouriteMovies>> fetchFavouriteMovie() {
        return null;
    }
}