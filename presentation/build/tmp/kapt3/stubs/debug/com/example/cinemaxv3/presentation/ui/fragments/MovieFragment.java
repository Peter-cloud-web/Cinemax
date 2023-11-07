package com.example.cinemaxv3.presentation.ui.fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.Glide;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.FragmentMovieBinding;
import com.example.cinemaxv3.presentation.ui.adapter.PopularMovieAdapter;
import com.example.cinemaxv3.presentation.ui.adapter.TopRatedMoviesAdapter;
import com.example.cinemaxv3.presentation.ui.adapter.UpComingMoviesAdapter;
import com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel.PopularMoviesViewModel;
import com.example.cinemaxv3.presentation.ui.viewmodels.topRatedMovieViewModel.TopRatedMovieViewModel;
import com.example.cinemaxv3.presentation.ui.viewmodels.upComingMoviesViewModel.UpComingMoviesViewModel;
import com.example.framework.receivers.ConnectivityObserver;
import com.example.framework.receivers.NetworkConnectivityObserver;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0002J\u001a\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0017J\"\u00102\u001a\u00020%2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\u0006\u0010&\u001a\u00020\'H\u0002J\b\u00107\u001a\u00020%H\u0002J\u0010\u00108\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b!\u0010\"\u00a8\u00069"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/fragments/MovieFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/example/cinemaxv3/presentation/ui/fragments/MovieDetailsFragmentArgs;", "getArgs", "()Lcom/example/cinemaxv3/presentation/ui/fragments/MovieDetailsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "networkConnectivityObserver", "Lcom/example/framework/receivers/NetworkConnectivityObserver;", "getNetworkConnectivityObserver", "()Lcom/example/framework/receivers/NetworkConnectivityObserver;", "networkConnectivityObserver$delegate", "Lkotlin/Lazy;", "popularMovieAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/PopularMovieAdapter;", "popularMoviesViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularMoviesViewModel/PopularMoviesViewModel;", "getPopularMoviesViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularMoviesViewModel/PopularMoviesViewModel;", "popularMoviesViewModel$delegate", "topRatedMovieViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/topRatedMovieViewModel/TopRatedMovieViewModel;", "getTopRatedMovieViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/topRatedMovieViewModel/TopRatedMovieViewModel;", "topRatedMovieViewModel$delegate", "topRatedMoviesAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/TopRatedMoviesAdapter;", "upComingMoviesAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/UpComingMoviesAdapter;", "upComingMoviesViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/upComingMoviesViewModel/UpComingMoviesViewModel;", "getUpComingMoviesViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/upComingMoviesViewModel/UpComingMoviesViewModel;", "upComingMoviesViewModel$delegate", "checkNetworkConnectivity", "", "binding", "Lcom/example/cinemaxv3/databinding/FragmentMovieBinding;", "displayPopularMovie", "fetchMovies", "initMembers", "imageLoader", "Lcoil/ImageLoader;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "popularMovieOnclick", "id", "", "name", "", "recyclerViewOnClick", "setUpViews", "presentation_debug"})
public final class MovieFragment extends androidx.fragment.app.Fragment {
    private com.example.cinemaxv3.presentation.ui.adapter.PopularMovieAdapter popularMovieAdapter;
    private com.example.cinemaxv3.presentation.ui.adapter.TopRatedMoviesAdapter topRatedMoviesAdapter;
    @org.jetbrains.annotations.NotNull
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private com.example.cinemaxv3.presentation.ui.adapter.UpComingMoviesAdapter upComingMoviesAdapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy networkConnectivityObserver$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy topRatedMovieViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy popularMoviesViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy upComingMoviesViewModel$delegate = null;
    
    public MovieFragment() {
        super();
    }
    
    private final com.example.cinemaxv3.presentation.ui.fragments.MovieDetailsFragmentArgs getArgs() {
        return null;
    }
    
    private final com.example.framework.receivers.NetworkConnectivityObserver getNetworkConnectivityObserver() {
        return null;
    }
    
    private final com.example.cinemaxv3.presentation.ui.viewmodels.topRatedMovieViewModel.TopRatedMovieViewModel getTopRatedMovieViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.presentation.ui.viewmodels.popularMoviesViewModel.PopularMoviesViewModel getPopularMoviesViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.presentation.ui.viewmodels.upComingMoviesViewModel.UpComingMoviesViewModel getUpComingMoviesViewModel() {
        return null;
    }
    
    @java.lang.Override
    @android.annotation.SuppressLint(value = {"SuspiciousIndentation"})
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initMembers(coil.ImageLoader imageLoader) {
    }
    
    private final void checkNetworkConnectivity(com.example.cinemaxv3.databinding.FragmentMovieBinding binding) {
    }
    
    private final void fetchMovies(com.example.cinemaxv3.databinding.FragmentMovieBinding binding) {
    }
    
    private final void setUpViews(com.example.cinemaxv3.databinding.FragmentMovieBinding binding) {
    }
    
    private final void recyclerViewOnClick() {
    }
    
    private final void displayPopularMovie(com.example.cinemaxv3.databinding.FragmentMovieBinding binding) {
    }
    
    private final void popularMovieOnclick(int id, java.lang.String name, com.example.cinemaxv3.databinding.FragmentMovieBinding binding) {
    }
}