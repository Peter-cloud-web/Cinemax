package com.example.cinemaxv3.view.ui.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.FragmentReviewsBinding;
import com.example.cinemaxv3.models.responses.Review;
import com.example.cinemaxv3.view.ui.adapter.MovieReviewsAdapter;
import com.example.cinemaxv3.view.ui.viewmodels.movieReviewsViewModel.MovieReviewsViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/fragments/ReviewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "movieReviewsViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieReviewsViewModel/MovieReviewsViewModel;", "getMovieReviewsViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/movieReviewsViewModel/MovieReviewsViewModel;", "movieReviewsViewModel$delegate", "Lkotlin/Lazy;", "reviewAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/MovieReviewsAdapter;", "loadMovieReviews", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showMovies", "binding", "Lcom/example/cinemaxv3/databinding/FragmentReviewsBinding;", "presentation_debug"})
public final class ReviewsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy movieReviewsViewModel$delegate = null;
    private com.example.cinemaxv3.view.ui.adapter.MovieReviewsAdapter reviewAdapter;
    
    public ReviewsFragment() {
        super();
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.movieReviewsViewModel.MovieReviewsViewModel getMovieReviewsViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadMovieReviews() {
    }
    
    private final void showMovies(com.example.cinemaxv3.databinding.FragmentReviewsBinding binding) {
    }
}