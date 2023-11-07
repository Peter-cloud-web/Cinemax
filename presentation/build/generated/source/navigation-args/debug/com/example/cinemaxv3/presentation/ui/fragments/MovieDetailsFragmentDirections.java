package com.example.cinemaxv3.presentation.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.cinemaxv3.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MovieDetailsFragmentDirections {
  private MovieDetailsFragmentDirections() {
  }

  @NonNull
  public static ActionMovieDetailsFragmentToReviewsFragment actionMovieDetailsFragmentToReviewsFragment(
      int movieId) {
    return new ActionMovieDetailsFragmentToReviewsFragment(movieId);
  }

  @NonNull
  public static ActionMovieDetailsFragmentToTrailersFragment actionMovieDetailsFragmentToTrailersFragment(
      int movieId, @NonNull String title) {
    return new ActionMovieDetailsFragmentToTrailersFragment(movieId, title);
  }

  public static class ActionMovieDetailsFragmentToReviewsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionMovieDetailsFragmentToReviewsFragment(int movieId) {
      this.arguments.put("movieId", movieId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionMovieDetailsFragmentToReviewsFragment setMovieId(int movieId) {
      this.arguments.put("movieId", movieId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("movieId")) {
        int movieId = (int) arguments.get("movieId");
        __result.putInt("movieId", movieId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_movieDetailsFragment_to_reviewsFragment;
    }

    @SuppressWarnings("unchecked")
    public int getMovieId() {
      return (int) arguments.get("movieId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMovieDetailsFragmentToReviewsFragment that = (ActionMovieDetailsFragmentToReviewsFragment) object;
      if (arguments.containsKey("movieId") != that.arguments.containsKey("movieId")) {
        return false;
      }
      if (getMovieId() != that.getMovieId()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getMovieId();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMovieDetailsFragmentToReviewsFragment(actionId=" + getActionId() + "){"
          + "movieId=" + getMovieId()
          + "}";
    }
  }

  public static class ActionMovieDetailsFragmentToTrailersFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionMovieDetailsFragmentToTrailersFragment(int movieId, @NonNull String title) {
      this.arguments.put("movieId", movieId);
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("title", title);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionMovieDetailsFragmentToTrailersFragment setMovieId(int movieId) {
      this.arguments.put("movieId", movieId);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionMovieDetailsFragmentToTrailersFragment setTitle(@NonNull String title) {
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("title", title);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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

    @Override
    public int getActionId() {
      return R.id.action_movieDetailsFragment_to_trailersFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMovieDetailsFragmentToTrailersFragment that = (ActionMovieDetailsFragmentToTrailersFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getMovieId();
      result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMovieDetailsFragmentToTrailersFragment(actionId=" + getActionId() + "){"
          + "movieId=" + getMovieId()
          + ", title=" + getTitle()
          + "}";
    }
  }
}
