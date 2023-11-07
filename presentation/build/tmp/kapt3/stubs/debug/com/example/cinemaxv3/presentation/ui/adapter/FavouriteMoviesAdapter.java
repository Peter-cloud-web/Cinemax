package com.example.cinemaxv3.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import coil.request.ImageRequest;
import com.example.cinemaxv3.databinding.ItemFavouriteMoviesBinding;
import com.example.framework.model.favourites.FavouriteMovies;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001f B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\u00020\u00122\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J)\u0010\u001c\u001a\u00020\u00122!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rJ\u001a\u0010\u001e\u001a\u00020\u00122\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\rR\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/FavouriteMoviesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/cinemaxv3/presentation/ui/adapter/FavouriteMoviesAdapter$FavouriteMoviesViewHolder;", "imageLoader", "Lcoil/ImageLoader;", "(Lcoil/ImageLoader;)V", "favouriteMovies", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/example/framework/model/favourites/FavouriteMovies;", "kotlin.jvm.PlatformType", "getFavouriteMovies", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "onDeleteMovieClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "onFavouriteMovieOnClickListener", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnDeleteMovieClickListener", "listener", "setOnItemClickListener", "Companion", "FavouriteMoviesViewHolder", "presentation_debug"})
public final class FavouriteMoviesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.cinemaxv3.presentation.ui.adapter.FavouriteMoviesAdapter.FavouriteMoviesViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final coil.ImageLoader imageLoader = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.example.framework.model.favourites.FavouriteMovies, kotlin.Unit> onFavouriteMovieOnClickListener;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onDeleteMovieClickListener;
    @org.jetbrains.annotations.NotNull
    private final androidx.recyclerview.widget.AsyncListDiffer<com.example.framework.model.favourites.FavouriteMovies> favouriteMovies = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.framework.model.favourites.FavouriteMovies> FavouriteMoviesComparator = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.cinemaxv3.presentation.ui.adapter.FavouriteMoviesAdapter.Companion Companion = null;
    
    @javax.inject.Inject
    public FavouriteMoviesAdapter(@org.jetbrains.annotations.NotNull
    coil.ImageLoader imageLoader) {
        super();
    }
    
    public final void setOnDeleteMovieClickListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> listener) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.recyclerview.widget.AsyncListDiffer<com.example.framework.model.favourites.FavouriteMovies> getFavouriteMovies() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.cinemaxv3.presentation.ui.adapter.FavouriteMoviesAdapter.FavouriteMoviesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.cinemaxv3.presentation.ui.adapter.FavouriteMoviesAdapter.FavouriteMoviesViewHolder holder, int position) {
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.framework.model.favourites.FavouriteMovies, kotlin.Unit> listener) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/FavouriteMoviesAdapter$Companion;", "", "()V", "FavouriteMoviesComparator", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/framework/model/favourites/FavouriteMovies;", "presentation_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/adapter/FavouriteMoviesAdapter$FavouriteMoviesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/cinemaxv3/databinding/ItemFavouriteMoviesBinding;", "(Lcom/example/cinemaxv3/presentation/ui/adapter/FavouriteMoviesAdapter;Lcom/example/cinemaxv3/databinding/ItemFavouriteMoviesBinding;)V", "getBinding", "()Lcom/example/cinemaxv3/databinding/ItemFavouriteMoviesBinding;", "presentation_debug"})
    public final class FavouriteMoviesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.cinemaxv3.databinding.ItemFavouriteMoviesBinding binding = null;
        
        public FavouriteMoviesViewHolder(@org.jetbrains.annotations.NotNull
        com.example.cinemaxv3.databinding.ItemFavouriteMoviesBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.cinemaxv3.databinding.ItemFavouriteMoviesBinding getBinding() {
            return null;
        }
    }
}