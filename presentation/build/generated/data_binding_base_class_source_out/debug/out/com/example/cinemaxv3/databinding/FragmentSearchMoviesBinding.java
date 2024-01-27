// Generated by view binder compiler. Do not edit!
package com.example.cinemaxv3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cinemaxv3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSearchMoviesBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView searchRecyclerView;

  @NonNull
  public final EditText searchView;

  private FragmentSearchMoviesBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar progressBar, @NonNull RecyclerView searchRecyclerView,
      @NonNull EditText searchView) {
    this.rootView = rootView;
    this.progressBar = progressBar;
    this.searchRecyclerView = searchRecyclerView;
    this.searchView = searchView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchMoviesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchMoviesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_search_movies, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchMoviesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.searchRecyclerView;
      RecyclerView searchRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (searchRecyclerView == null) {
        break missingId;
      }

      id = R.id.searchView;
      EditText searchView = ViewBindings.findChildViewById(rootView, id);
      if (searchView == null) {
        break missingId;
      }

      return new FragmentSearchMoviesBinding((ConstraintLayout) rootView, progressBar,
          searchRecyclerView, searchView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}