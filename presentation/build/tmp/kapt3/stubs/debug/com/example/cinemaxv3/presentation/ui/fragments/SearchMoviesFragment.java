package com.example.cinemaxv3.view.ui.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.FragmentSearchMoviesBinding;
import com.example.cinemaxv3.view.ui.adapter.SearchMoviesAdapter;
import com.example.cinemaxv3.view.ui.viewmodels.searchedMoviesViewModel.SearchedMoviesViewModel;
import com.example.cinemaxv3.util.Constants;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/fragments/SearchMoviesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "searchMoviesAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/SearchMoviesAdapter;", "searchedMoviesViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/searchedMoviesViewModel/SearchedMoviesViewModel;", "getSearchedMoviesViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/searchedMoviesViewModel/SearchedMoviesViewModel;", "searchedMoviesViewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "presentation_debug"})
public final class SearchMoviesFragment extends androidx.fragment.app.Fragment {
    private com.example.cinemaxv3.view.ui.adapter.SearchMoviesAdapter searchMoviesAdapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy searchedMoviesViewModel$delegate = null;
    
    public SearchMoviesFragment() {
        super();
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.searchedMoviesViewModel.SearchedMoviesViewModel getSearchedMoviesViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}