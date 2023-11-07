package com.example.cinemaxv3.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import coil.request.ImageRequest;
import com.example.cinemaxv3.databinding.ItemSimilarMoviesBinding;
import com.example.framework.model.similarMoviesResponse.SimilarMovies;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0016\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/SimilarMoviesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/cinemaxv3/presentation/ui/adapter/SimilarMoviesAdapter$SimilarMoviesViewHolder;", "imageLoader", "Lcoil/ImageLoader;", "(Lcoil/ImageLoader;)V", "similarMoviesDifferList", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/example/framework/model/similarMoviesResponse/SimilarMovies;", "kotlin.jvm.PlatformType", "getSimilarMoviesDifferList", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "SimilarMoviesViewHolder", "presentation_debug"})
public final class SimilarMoviesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.cinemaxv3.presentation.ui.adapter.SimilarMoviesAdapter.SimilarMoviesViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final coil.ImageLoader imageLoader = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.AsyncListDiffer<com.example.framework.model.similarMoviesResponse.SimilarMovies> similarMoviesDifferList = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.framework.model.similarMoviesResponse.SimilarMovies> SimilarMoviesComparator = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.cinemaxv3.presentation.ui.adapter.SimilarMoviesAdapter.Companion Companion = null;
    
    @javax.inject.Inject
    public SimilarMoviesAdapter(@org.jetbrains.annotations.NotNull
    coil.ImageLoader imageLoader) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.AsyncListDiffer<com.example.framework.model.similarMoviesResponse.SimilarMovies> getSimilarMoviesDifferList() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.cinemaxv3.presentation.ui.adapter.SimilarMoviesAdapter.SimilarMoviesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.presentation.ui.adapter.SimilarMoviesAdapter.SimilarMoviesViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/SimilarMoviesAdapter$Companion;", "", "()V", "SimilarMoviesComparator", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/framework/model/similarMoviesResponse/SimilarMovies;", "presentation_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/SimilarMoviesAdapter$SimilarMoviesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/cinemaxv3/databinding/ItemSimilarMoviesBinding;", "(Lcom/example/cinemaxv3/presentation/ui/adapter/SimilarMoviesAdapter;Lcom/example/cinemaxv3/databinding/ItemSimilarMoviesBinding;)V", "getBinding", "()Lcom/example/cinemaxv3/databinding/ItemSimilarMoviesBinding;", "presentation_debug"})
    public final class SimilarMoviesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.cinemaxv3.databinding.ItemSimilarMoviesBinding binding = null;
        
        public SimilarMoviesViewHolder(@org.jetbrains.annotations.NotNull
        com.example.cinemaxv3.databinding.ItemSimilarMoviesBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.cinemaxv3.databinding.ItemSimilarMoviesBinding getBinding() {
            return null;
        }
    }
}