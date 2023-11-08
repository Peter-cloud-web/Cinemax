package com.example.cinemaxv3.view.ui.fragments;

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

public class TrailersFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private TrailersFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private TrailersFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TrailersFragmentArgs fromBundle(@NonNull Bundle bundle) {
    TrailersFragmentArgs __result = new TrailersFragmentArgs();
    bundle.setClassLoader(TrailersFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("movieId")) {
      int movieId;
      movieId = bundle.getInt("movieId");
      __result.arguments.put("movieId", movieId);
    } else {
      throw new IllegalArgumentException("Required argument \"movieId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("title")) {
      String title;
      title = bundle.getString("title");
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("title", title);
    } else {
      throw new IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TrailersFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    TrailersFragmentArgs __result = new TrailersFragmentArgs();
    if (savedStateHandle.contains("movieId")) {
      int movieId;
      movieId = savedStateHandle.get("movieId");
      __result.arguments.put("movieId", movieId);
    } else {
      throw new IllegalArgumentException("Required argument \"movieId\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("title")) {
      String title;
      title = savedStateHandle.get("title");
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("title", title);
    } else {
      throw new IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getMovieId() {
    return (int) arguments.get("movieId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getTitle() {
    return (String) arguments.get("title");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("movieId")) {
      int movieId = (int) arguments.get("movieId");
      __result.putInt("movieId", movieId);
    }
    if (arguments.containsKey("title")) {
      String title = (String) arguments.get("title");
      __result.putString("title", title);
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
    if (arguments.containsKey("title")) {
      String title = (String) arguments.get("title");
      __result.set("title", title);
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
    TrailersFragmentArgs that = (TrailersFragmentArgs) object;
    if (arguments.containsKey("movieId") != that.arguments.containsKey("movieId")) {
      return false;
    }
    if (getMovieId() != that.getMovieId()) {
      return false;
    }
    if (arguments.containsKey("title") != that.arguments.containsKey("title")) {
      return false;
    }
    if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getMovieId();
    result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TrailersFragmentArgs{"
        + "movieId=" + getMovieId()
        + ", title=" + getTitle()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull TrailersFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(int movieId, @NonNull String title) {
      this.arguments.put("movieId", movieId);
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("title", title);
    }

    @NonNull
    public TrailersFragmentArgs build() {
      TrailersFragmentArgs result = new TrailersFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setMovieId(int movieId) {
      this.arguments.put("movieId", movieId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setTitle(@NonNull String title) {
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("title", title);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public int getMovieId() {
      return (int) arguments.get("movieId");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getTitle() {
      return (String) arguments.get("title");
    }
  }
}
