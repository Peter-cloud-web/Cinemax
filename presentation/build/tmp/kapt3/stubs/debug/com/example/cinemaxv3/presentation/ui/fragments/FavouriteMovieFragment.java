package com.example.cinemaxv3.view.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.FragmentFavouriteMovieBinding;
import com.example.cinemaxv3.view.ui.adapter.FavouriteMoviesAdapter;
import com.example.cinemaxv3.view.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel;
import com.example.framework.model.favourites.FavouriteMovies;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/fragments/FavouriteMovieFragment;", "Landroidx/fragment/app/Fragment;", "()V", "favouriteMoviesAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/FavouriteMoviesAdapter;", "favouriteMoviesViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/favouriteMoviesViewModel/FavouriteMoviesViewModel;", "getFavouriteMoviesViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/favouriteMoviesViewModel/FavouriteMoviesViewModel;", "favouriteMoviesViewModel$delegate", "Lkotlin/Lazy;", "deleteFavouriteMovie", "", "handleItemOnClick", "navigateToDetailsScreen", "favouriteMovies", "Lcom/example/framework/model/favourites/FavouriteMovies;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateRecyclerView", "binding", "Lcom/example/cinemaxv3/databinding/FragmentFavouriteMovieBinding;", "presentation_debug"})
public final class FavouriteMovieFragment extends androidx.fragment.app.Fragment {
    private com.example.cinemaxv3.view.ui.adapter.FavouriteMoviesAdapter favouriteMoviesAdapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy favouriteMoviesViewModel$delegate = null;
    
    public FavouriteMovieFragment() {
        super();
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel getFavouriteMoviesViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleItemOnClick() {
    }
    
    private final void navigateToDetailsScreen(com.example.framework.model.favourites.FavouriteMovies favouriteMovies) {
    }
    
    private final void deleteFavouriteMovie() {
    }
    
    private final void populateRecyclerView(com.example.cinemaxv3.databinding.FragmentFavouriteMovieBinding binding) {
    }
}