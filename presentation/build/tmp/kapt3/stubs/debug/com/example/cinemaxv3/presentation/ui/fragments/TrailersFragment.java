package com.example.cinemaxv3.view.ui.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.FragmentTrailersBinding;
import com.example.cinemaxv3.view.ui.adapter.MovieCastsAdapter;
import com.example.cinemaxv3.view.ui.adapter.SimilarMoviesAdapter;
import com.example.cinemaxv3.view.ui.viewmodels.movieCastViewModel.MovieCastsViewModel;
import com.example.cinemaxv3.view.ui.viewmodels.movieTrailerViewModel.MovieTrailerViewModel;
import com.example.cinemaxv3.view.ui.viewmodels.similarMoviesViewModel.SimilarMoviesViewModel;
import com.example.framework.model.movieCasts.Cast;
import com.example.framework.model.similarMoviesResponse.SimilarMovies;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020 J\u000e\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u001a\u0010&\u001a\u00020 2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u0010.\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/fragments/TrailersFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/example/cinemaxv3/presentation/ui/fragments/TrailersFragmentArgs;", "getArgs", "()Lcom/example/cinemaxv3/presentation/ui/fragments/TrailersFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "castsAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/MovieCastsAdapter;", "movieCastsViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieCastViewModel/MovieCastsViewModel;", "getMovieCastsViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieCastViewModel/MovieCastsViewModel;", "movieCastsViewModel$delegate", "Lkotlin/Lazy;", "movieTrailerViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieTrailerViewModel/MovieTrailerViewModel;", "getMovieTrailerViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieTrailerViewModel/MovieTrailerViewModel;", "movieTrailerViewModel$delegate", "similarMoviesAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/SimilarMoviesAdapter;", "similarMoviesViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/similarMoviesViewModel/SimilarMoviesViewModel;", "getSimilarMoviesViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/similarMoviesViewModel/SimilarMoviesViewModel;", "similarMoviesViewModel$delegate", "videoView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "collectArgumentsAndPerformOperations", "", "binding", "Lcom/example/cinemaxv3/databinding/FragmentTrailersBinding;", "loadMovieCasts", "loadSimilarMovies", "movieCastsRecyclerView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "playTrailers", "id", "", "similarMoviesRecyclerView", "presentation_debug"})
public final class TrailersFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy movieTrailerViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy movieCastsViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy similarMoviesViewModel$delegate = null;
    private com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView videoView;
    private com.example.cinemaxv3.view.ui.adapter.MovieCastsAdapter castsAdapter;
    private com.example.cinemaxv3.view.ui.adapter.SimilarMoviesAdapter similarMoviesAdapter;
    @org.jetbrains.annotations.NotNull
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    
    public TrailersFragment() {
        super();
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.movieTrailerViewModel.MovieTrailerViewModel getMovieTrailerViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.movieCastViewModel.MovieCastsViewModel getMovieCastsViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.similarMoviesViewModel.SimilarMoviesViewModel getSimilarMoviesViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.view.ui.fragments.TrailersFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void collectArgumentsAndPerformOperations(com.example.cinemaxv3.databinding.FragmentTrailersBinding binding) {
    }
    
    private final void playTrailers(int id) {
    }
    
    public final void loadMovieCasts() {
    }
    
    public final void movieCastsRecyclerView(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.databinding.FragmentTrailersBinding binding) {
    }
    
    public final void loadSimilarMovies() {
    }
    
    public final void similarMoviesRecyclerView(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.databinding.FragmentTrailersBinding binding) {
    }
}