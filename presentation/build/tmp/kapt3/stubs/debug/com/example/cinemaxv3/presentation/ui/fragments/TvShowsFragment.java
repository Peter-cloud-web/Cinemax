package com.example.cinemaxv3.view.ui.fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.FragmentTvShowsBinding;
import com.example.cinemaxv3.view.ui.adapter.SharedTvShowsAdapter;
import com.example.cinemaxv3.view.ui.viewmodels.TopRatedTvShowsViewModel.TopRatedTvShowsViewModel;
import com.example.cinemaxv3.view.ui.viewmodels.popularTvShowViewModel.PopularTvShowViewModel;
import com.example.cinemaxv3.view.ui.viewmodels.tvShowsAiringTodayViewModel.TvShowsAiringTodayViewModel;
import com.example.cinemaxv3.view.ui.viewmodels.tvShowsOnTheAirViewModel.TvShowsOnTheAirViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u001a\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u001fH\u0002R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00065"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/fragments/TvShowsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "currentAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "popularTvShowViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularTvShowViewModel/PopularTvShowViewModel;", "getPopularTvShowViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/popularTvShowViewModel/PopularTvShowViewModel;", "popularTvShowViewModel$delegate", "Lkotlin/Lazy;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sharedTvShowsAdapter", "Lcom/example/cinemaxv3/presentation/ui/adapter/SharedTvShowsAdapter;", "topRatedTvShowsViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/TopRatedTvShowsViewModel/TopRatedTvShowsViewModel;", "getTopRatedTvShowsViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/TopRatedTvShowsViewModel/TopRatedTvShowsViewModel;", "topRatedTvShowsViewModel$delegate", "tvShowsAiringTodayViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/tvShowsAiringTodayViewModel/TvShowsAiringTodayViewModel;", "getTvShowsAiringTodayViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/tvShowsAiringTodayViewModel/TvShowsAiringTodayViewModel;", "tvShowsAiringTodayViewModel$delegate", "tvShowsOnTheAirViewModel", "Lcom/example/cinemaxv3/presentation/ui/viewmodels/tvShowsOnTheAirViewModel/TvShowsOnTheAirViewModel;", "getTvShowsOnTheAirViewModel", "()Lcom/example/cinemaxv3/presentation/ui/viewmodels/tvShowsOnTheAirViewModel/TvShowsOnTheAirViewModel;", "tvShowsOnTheAirViewModel$delegate", "initializations", "", "imageLoader", "Lcoil/ImageLoader;", "loadDefaultTvShowsBeforeOptions", "loadViewsToRecyclerviews", "binding", "Lcom/example/cinemaxv3/databinding/FragmentTvShowsBinding;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "tvShowsInDetail", "presentation_debug"})
public final class TvShowsFragment extends androidx.fragment.app.Fragment {
    private com.example.cinemaxv3.view.ui.adapter.SharedTvShowsAdapter sharedTvShowsAdapter;
    private androidx.recyclerview.widget.RecyclerView.Adapter<?> currentAdapter;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy topRatedTvShowsViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy popularTvShowViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy tvShowsAiringTodayViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy tvShowsOnTheAirViewModel$delegate = null;
    
    public TvShowsFragment() {
        super();
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.TopRatedTvShowsViewModel.TopRatedTvShowsViewModel getTopRatedTvShowsViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.popularTvShowViewModel.PopularTvShowViewModel getPopularTvShowViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.tvShowsAiringTodayViewModel.TvShowsAiringTodayViewModel getTvShowsAiringTodayViewModel() {
        return null;
    }
    
    private final com.example.cinemaxv3.view.ui.viewmodels.tvShowsOnTheAirViewModel.TvShowsOnTheAirViewModel getTvShowsOnTheAirViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializations(coil.ImageLoader imageLoader) {
    }
    
    private final void loadViewsToRecyclerviews(com.example.cinemaxv3.databinding.FragmentTvShowsBinding binding) {
    }
    
    private final void loadDefaultTvShowsBeforeOptions() {
    }
    
    private final void tvShowsInDetail() {
    }
    
    @java.lang.Override
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu, @org.jetbrains.annotations.NotNull
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
}