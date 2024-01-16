package com.example.paging.pager;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import com.example.domain.pager.TvShowsOnTheAirPager;
import com.example.domain.repository.RemoteMoviesRepository;
import com.example.domain.entities.model.tvShowsResponse.TvShowsResults;
import com.example.paging.pagingSource.TvShowsOnTheAirPagingSource;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/paging/pager/TvShowsOnTheAirImpl;", "Lcom/example/domain/pager/TvShowsOnTheAirPager;", "repository", "Lcom/example/domain/repository/RemoteMoviesRepository;", "(Lcom/example/domain/repository/RemoteMoviesRepository;)V", "getTvShowsOnTheAir", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/domain/entities/model/tvShowsResponse/TvShowsResults;", "data_debug"})
public final class TvShowsOnTheAirImpl implements com.example.domain.pager.TvShowsOnTheAirPager {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.RemoteMoviesRepository repository = null;
    
    @javax.inject.Inject
    public TvShowsOnTheAirImpl(@org.jetbrains.annotations.NotNull
    com.example.domain.repository.RemoteMoviesRepository repository) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.example.domain.entities.model.tvShowsResponse.TvShowsResults>> getTvShowsOnTheAir() {
        return null;
    }
}