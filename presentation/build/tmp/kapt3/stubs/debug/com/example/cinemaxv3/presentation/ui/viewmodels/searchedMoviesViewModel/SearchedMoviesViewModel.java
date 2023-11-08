package com.example.cinemaxv3.view.ui.viewmodels.searchedMoviesViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.framework.movieDto.MovieResponseDto;
import com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase;
import com.example.service.MovieApi;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/searchedMoviesViewModel/SearchedMoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "searchMoviesUseCase", "Lcom/example/domain/use_cases/searchedMovies_usecase/SearchMoviesUseCase;", "api", "Lcom/example/service/MovieApi;", "(Lcom/example/domain/use_cases/searchedMovies_usecase/SearchMoviesUseCase;Lcom/example/service/MovieApi;)V", "SearchResponse", "Landroidx/lifecycle/LiveData;", "Lcom/example/framework/movieDto/MovieResponseDto;", "getSearchResponse", "()Landroidx/lifecycle/LiveData;", "_searchMoviesResponse", "Landroidx/lifecycle/MutableLiveData;", "searchMovies", "", "query", "", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SearchedMoviesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase searchMoviesUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.service.MovieApi api = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.framework.movieDto.MovieResponseDto> _searchMoviesResponse = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.example.framework.movieDto.MovieResponseDto> SearchResponse = null;
    
    @javax.inject.Inject
    public SearchedMoviesViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase searchMoviesUseCase, @org.jetbrains.annotations.NotNull
    com.example.service.MovieApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.framework.movieDto.MovieResponseDto> getSearchResponse() {
        return null;
    }
    
    public final void searchMovies(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
}