package com.example.cinemaxv3.presentation.ui.fragments;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding;
import com.example.cinemaxv3.presentation.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel;
import com.example.framework.model.favourites.FavouriteMovies;
import com.google.android.material.snackbar.Snackbar;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ>\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001aJ\u001e\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001dJ&\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006&"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/fragments/MovieDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/example/cinemaxv3/presentation/ui/fragments/MovieDetailsFragmentArgs;", "getArgs", "()Lcom/example/cinemaxv3/presentation/ui/fragments/MovieDetailsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "favouriteMoviesViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/favouriteMoviesViewModel/FavouriteMoviesViewModel;", "getFavouriteMoviesViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/favouriteMoviesViewModel/FavouriteMoviesViewModel;", "favouriteMoviesViewModel$delegate", "Lkotlin/Lazy;", "collectArgumentsAndPerformOperation", "", "binding", "Lcom/example/cinemaxv3/databinding/FragmentMovieDetailsBinding;", "view", "Landroid/view/View;", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "reviewClickListener", "movieId", "", "saveBookMarks", "image", "", "backdrop", "title", "description", "rating", "", "id", "shareClickListener", "trailerClickListener", "presentation_debug"})
public final class MovieDetailsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy favouriteMoviesViewModel$delegate = null;
    
    public MovieDetailsFragment() {
        super();
    }
    
    private final com.example.cinemaxv3.presentation.ui.fragments.MovieDetailsFragmentArgs getArgs() {
        return null;
    }
    
    private final com.example.cinemaxv3.presentation.ui.viewmodels.favouriteMoviesViewModel.FavouriteMoviesViewModel getFavouriteMoviesViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void collectArgumentsAndPerformOperation(com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding binding, android.view.View view) {
    }
    
    public final void reviewClickListener(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding binding, int movieId) {
    }
    
    public final void trailerClickListener(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding binding, int movieId, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public final void saveBookMarks(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding binding, @org.jetbrains.annotations.NotNull
    java.lang.String image, @org.jetbrains.annotations.NotNull
    java.lang.String backdrop, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String description, float rating, int id) {
    }
    
    public final void shareClickListener(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.databinding.FragmentMovieDetailsBinding binding, int id, @org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
}