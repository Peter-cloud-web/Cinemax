package com.example.cinemaxv3.view.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import coil.request.ImageRequest;
import com.example.cinemaxv3.databinding.ItemMoviecrewBinding;
import com.example.framework.model.movieCasts.Cast;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0016\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/MovieCastsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/cinemaxv3/presentation/ui/adapter/MovieCastsAdapter$MovieCastsViewHolder;", "imageLoader", "Lcoil/ImageLoader;", "(Lcoil/ImageLoader;)V", "comparator", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/example/framework/model/movieCasts/Cast;", "kotlin.jvm.PlatformType", "getComparator", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MovieCastsViewHolder", "presentation_debug"})
public final class MovieCastsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.cinemaxv3.view.ui.adapter.MovieCastsAdapter.MovieCastsViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final coil.ImageLoader imageLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.AsyncListDiffer<com.example.framework.model.movieCasts.Cast> comparator = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.framework.model.movieCasts.Cast> MovieCastModelComparator = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.cinemaxv3.view.ui.adapter.MovieCastsAdapter.Companion Companion = null;
    
    @javax.inject.Inject
    public MovieCastsAdapter(@org.jetbrains.annotations.NotNull
    coil.ImageLoader imageLoader) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.AsyncListDiffer<com.example.framework.model.movieCasts.Cast> getComparator() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.cinemaxv3.view.ui.adapter.MovieCastsAdapter.MovieCastsViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.view.ui.adapter.MovieCastsAdapter.MovieCastsViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/MovieCastsAdapter$Companion;", "", "()V", "MovieCastModelComparator", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/framework/model/movieCasts/Cast;", "presentation_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/MovieCastsAdapter$MovieCastsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/cinemaxv3/databinding/ItemMoviecrewBinding;", "(Lcom/example/cinemaxv3/presentation/ui/adapter/MovieCastsAdapter;Lcom/example/cinemaxv3/databinding/ItemMoviecrewBinding;)V", "getBinding", "()Lcom/example/cinemaxv3/databinding/ItemMoviecrewBinding;", "presentation_debug"})
    public final class MovieCastsViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.cinemaxv3.databinding.ItemMoviecrewBinding binding = null;
        
        public MovieCastsViewHolder(@org.jetbrains.annotations.NotNull
        com.example.cinemaxv3.databinding.ItemMoviecrewBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.cinemaxv3.databinding.ItemMoviecrewBinding getBinding() {
            return null;
        }
    }
}