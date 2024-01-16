package com.example.paging.pager;

import androidx.paging.ExperimentalPagingApi;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.cinemaxv3.models.UpComingMovies;
import com.example.db.MovieDatabase;
import com.example.domain.pager.UpComingPagingMovies;
import com.example.domain.repository.RemoteMoviesRepository;
import com.example.paging.mediators.UpComingMoviesMediator;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/paging/pager/UpComingMovieImpl;", "Lcom/example/domain/pager/UpComingPagingMovies;", "movieDatabase", "Lcom/example/db/MovieDatabase;", "repository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "(Lcom/example/db/MovieDatabase;Lcom/example/domain/repository/RemoteMoviesRepository;)V", "getUpComingMovies", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/cinemaxv3/models/UpComingMovies;", "data_debug"})
public final class UpComingMovieImpl implements com.example.domain.pager.UpComingPagingMovies {
    @org.jetbrains.annotations.NotNull
    private final com.example.db.MovieDatabase movieDatabase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.RemoteMoviesRepository repository = null;
    
    @javax.inject.Inject
    public UpComingMovieImpl(@org.jetbrains.annotations.NotNull
    com.example.db.MovieDatabase movieDatabase, @org.jetbrains.annotations.NotNull
    com.example.domain.repository.RemoteMoviesRepository repository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.cinemaxv3.models.UpComingMovies>> getUpComingMovies() {
        return null;
    }
}