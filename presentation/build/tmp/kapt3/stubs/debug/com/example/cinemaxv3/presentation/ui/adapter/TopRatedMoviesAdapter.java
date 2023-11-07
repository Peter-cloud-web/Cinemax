package com.example.cinemaxv3.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import coil.request.ImageRequest;
import com.example.cinemaxv3.databinding.ItemMoviesBinding;
import com.example.cinemaxv3.models.TopRatedMovies;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0014\u0015B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/TopRatedMoviesAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/example/cinemaxv3/models/TopRatedMovies;", "Lcom/example/cinemaxv3/presentation/ui/adapter/TopRatedMoviesAdapter$TopRatedViewHolder;", "imageLoader", "Lcoil/ImageLoader;", "(Lcoil/ImageLoader;)V", "onMovieClickListener", "Lkotlin/Function1;", "", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "listener", "Companion", "TopRatedViewHolder", "presentation_debug"})
public final class TopRatedMoviesAdapter extends androidx.paging.PagingDataAdapter<com.example.cinemaxv3.models.TopRatedMovies, com.example.cinemaxv3.presentation.ui.adapter.TopRatedMoviesAdapter.TopRatedViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final coil.ImageLoader imageLoader = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.example.cinemaxv3.models.TopRatedMovies, kotlin.Unit> onMovieClickListener;
    @org.jetbrains.annotations.NotNull
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.cinemaxv3.models.TopRatedMovies> TopMovieModelComparator = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.cinemaxv3.presentation.ui.adapter.TopRatedMoviesAdapter.Companion Companion = null;
    
    @javax.inject.Inject
    public TopRatedMoviesAdapter(@org.jetbrains.annotations.NotNull
    coil.ImageLoader imageLoader) {
        super(null, null, null);
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.presentation.ui.adapter.TopRatedMoviesAdapter.TopRatedViewHolder holder, int position) {
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.cinemaxv3.models.TopRatedMovies, kotlin.Unit> listener) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.cinemaxv3.presentation.ui.adapter.TopRatedMoviesAdapter.TopRatedViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/TopRatedMoviesAdapter$Companion;", "", "()V", "TopMovieModelComparator", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/cinemaxv3/models/TopRatedMovies;", "presentation_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/TopRatedMoviesAdapter$TopRatedViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/cinemaxv3/databinding/ItemMoviesBinding;", "(Lcom/example/cinemaxv3/presentation/ui/adapter/TopRatedMoviesAdapter;Lcom/example/cinemaxv3/databinding/ItemMoviesBinding;)V", "getBinding", "()Lcom/example/cinemaxv3/databinding/ItemMoviesBinding;", "presentation_debug"})
    public final class TopRatedViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.cinemaxv3.databinding.ItemMoviesBinding binding = null;
        
        public TopRatedViewHolder(@org.jetbrains.annotations.NotNull
        com.example.cinemaxv3.databinding.ItemMoviesBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.cinemaxv3.databinding.ItemMoviesBinding getBinding() {
            return null;
        }
    }
}