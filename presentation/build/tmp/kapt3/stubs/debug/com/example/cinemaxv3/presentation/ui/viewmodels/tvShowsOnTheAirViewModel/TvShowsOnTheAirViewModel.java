package com.example.cinemaxv3.view.ui.viewmodels.tvShowsOnTheAirViewModel;

import androidx.lifecycle.ViewModel;
import com.bumptech.glide.load.HttpException;
import com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel.UiStates;
import com.example.data.paging.pagingSource.TvShowsOnTheAirUseCase;
import com.example.framework.model.tvShowsResponse.TvShowsResults;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.io.IOException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/viewmodels/tvShowsOnTheAirViewModel/TvShowsOnTheAirViewModel;", "Landroidx/lifecycle/ViewModel;", "tvShowsOnTheAirUseCase", "Lcom/example/data/paging/pagingSource/TvShowsOnTheAirUseCase;", "(Lcom/example/data/paging/pagingSource/TvShowsOnTheAirUseCase;)V", "_tvShowsOnTheAir", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularMoviesViewModel/UiStates;", "Lcom/example/framework/model/tvShowsResponse/TvShowsResults;", "tvShowsOnTheAir", "Lkotlinx/coroutines/flow/StateFlow;", "getTvShowsOnTheAir", "()Lkotlinx/coroutines/flow/StateFlow;", "", "handleTvShowsOnTheAirErrors", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class TvShowsOnTheAirViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.paging.pagingSource.TvShowsOnTheAirUseCase tvShowsOnTheAirUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel.UiStates<com.example.framework.model.tvShowsResponse.TvShowsResults>> _tvShowsOnTheAir = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel.UiStates<com.example.framework.model.tvShowsResponse.TvShowsResults>> tvShowsOnTheAir = null;
    
    @javax.inject.Inject
    public TvShowsOnTheAirViewModel(@org.jetbrains.annotations.NotNull
    com.example.data.paging.pagingSource.TvShowsOnTheAirUseCase tvShowsOnTheAirUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.cinemaxv3.view.ui.viewmodels.popularMoviesViewModel.UiStates<com.example.framework.model.tvShowsResponse.TvShowsResults>> getTvShowsOnTheAir() {
        return null;
    }
    
    public final void getTvShowsOnTheAir() {
    }
    
    private final java.lang.String handleTvShowsOnTheAirErrors(java.lang.Exception e) {
        return null;
    }
}