package com.example.cinemaxv3.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import coil.request.ImageRequest;
import com.example.cinemaxv3.databinding.ItemSearchMoviesBinding;
import com.example.cinemaxv3.models.Movie;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001a\u0010\u0018\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\b0\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/SearchMoviesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/cinemaxv3/presentation/ui/adapter/SearchMoviesAdapter$SearchMoviesViewHolder;", "imageLoader", "Lcoil/ImageLoader;", "(Lcoil/ImageLoader;)V", "onMovieClickListener", "Lkotlin/Function1;", "Lcom/example/cinemaxv3/models/Movie;", "", "searchMovies", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getSearchMovies", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "listener", "Companion", "SearchMoviesViewHolder", "presentation_debug"})
public final class SearchMoviesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.cinemaxv3.presentation.ui.adapter.SearchMoviesAdapter.SearchMoviesViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final coil.ImageLoader imageLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.AsyncListDiffer<com.example.cinemaxv3.models.Movie> searchMovies = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.example.cinemaxv3.models.Movie, kotlin.Unit> onMovieClickListener;
    @org.jetbrains.annotations.NotNull
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.cinemaxv3.models.Movie> SearchMoviesComparator = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.cinemaxv3.presentation.ui.adapter.SearchMoviesAdapter.Companion Companion = null;
    
    @javax.inject.Inject
    public SearchMoviesAdapter(@org.jetbrains.annotations.NotNull
    coil.ImageLoader imageLoader) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.AsyncListDiffer<com.example.cinemaxv3.models.Movie> getSearchMovies() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.cinemaxv3.presentation.ui.adapter.SearchMoviesAdapter.SearchMoviesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.presentation.ui.adapter.SearchMoviesAdapter.SearchMoviesViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.cinemaxv3.models.Movie, kotlin.Unit> listener) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/SearchMoviesAdapter$Companion;", "", "()V", "SearchMoviesComparator", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/cinemaxv3/models/Movie;", "presentation_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/SearchMoviesAdapter$SearchMoviesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/cinemaxv3/databinding/ItemSearchMoviesBinding;", "(Lcom/example/cinemaxv3/presentation/ui/adapter/SearchMoviesAdapter;Lcom/example/cinemaxv3/databinding/ItemSearchMoviesBinding;)V", "getBinding", "()Lcom/example/cinemaxv3/databinding/ItemSearchMoviesBinding;", "presentation_debug"})
    public final class SearchMoviesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.cinemaxv3.databinding.ItemSearchMoviesBinding binding = null;
        
        public SearchMoviesViewHolder(@org.jetbrains.annotations.NotNull
        com.example.cinemaxv3.databinding.ItemSearchMoviesBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.cinemaxv3.databinding.ItemSearchMoviesBinding getBinding() {
            return null;
        }
    }
}