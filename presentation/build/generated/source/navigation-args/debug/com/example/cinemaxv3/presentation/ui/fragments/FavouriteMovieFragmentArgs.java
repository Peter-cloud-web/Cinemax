package com.example.cinemaxv3.presentation.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FavouriteMovieFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private FavouriteMovieFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private FavouriteMovieFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FavouriteMovieFragmentArgs fromBundle(@NonNull Bundle bundle) {
    FavouriteMovieFragmentArgs __result = new FavouriteMovieFragmentArgs();
    bundle.setClassLoader(FavouriteMovieFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("movieId")) {
      int movieId;
      movieId = bundle.getInt("movieId");
      __result.arguments.put("movieId", movieId);
    } else {
      throw new IllegalArgumentException("Required argument \"movieId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static FavouriteMovieFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    FavouriteMovieFragmentArgs __result = new FavouriteMovieFragmentArgs();
    if (savedStateHandle.contains("movieId")) {
      int movieId;
      movieId = savedStateHandle.get("movieId");
      __result.arguments.put("movieId", movieId);
    } else {
      throw new IllegalArgumentException("Required argument \"movieId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getMovieId() {
    return (int) arguments.get("movieId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("movieId")) {
      int movieId = (int) arguments.get("movieId");
      __result.putInt("movieId", movieId);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("movieId")) {
      int movieId = (int) arguments.get("movieId");
      __result.set("movieId", movieId);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    FavouriteMovieFragmentArgs that = (FavouriteMovieFragmentArgs) object;
    if (arguments.containsKey("movieId") != that.arguments.containsKey("movieId")) {
      return false;
    }
    if (getMovieId() != that.getMovieId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getMovieId();
    return result;
  }

  @Override
  public String toString() {
    return "FavouriteMovieFragmentArgs{"
        + "movieId=" + getMovieId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull FavouriteMovieFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(int movieId) {
      this.arguments.put("movieId", movieId);
    }

    @NonNull
    public FavouriteMovieFragmentArgs build() {
      FavouriteMovieFragmentArgs result = new FavouriteMovieFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setMovieId(int movieId) {
      this.arguments.put("movieId", movieId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public int getMovieId() {
      return (int) arguments.get("movieId");
    }
  }
}
