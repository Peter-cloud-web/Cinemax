package com.example.cinemaxv3.view.ui.fragments;

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

public class TvShowsFragmentDirections {
  private TvShowsFragmentDirections() {
  }

  @NonNull
  public static ActionTvShowsFragmentToMovieDetailsFragment actionTvShowsFragmentToMovieDetailsFragment(
      @NonNull String image, @NonNull String backdrop, @NonNull String title,
      @NonNull String description, float rating, int id) {
    return new ActionTvShowsFragmentToMovieDetailsFragment(image, backdrop, title, description, rating, id);
  }

  public static class ActionTvShowsFragmentToMovieDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionTvShowsFragmentToMovieDetailsFragment(@NonNull String image,
        @NonNull String backdrop, @NonNull String title, @NonNull String description, float rating,
        int id) {
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("image", image);
      if (backdrop == null) {
        throw new IllegalArgumentException("Argument \"backdrop\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("backdrop", backdrop);
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("title", title);
      if (description == null) {
        throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("description", description);
      this.arguments.put("rating", rating);
      this.arguments.put("id", id);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTvShowsFragmentToMovieDetailsFragment setImage(@NonNull String image) {
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("image", image);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTvShowsFragmentToMovieDetailsFragment setBackdrop(@NonNull String backdrop) {
      if (backdrop == null) {
        throw new IllegalArgumentException("Argument \"backdrop\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("backdrop", backdrop);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTvShowsFragmentToMovieDetailsFragment setTitle(@NonNull String title) {
      if (title == null) {
        throw new IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("title", title);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTvShowsFragmentToMovieDetailsFragment setDescription(@NonNull String description) {
      if (description == null) {
        throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("description", description);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTvShowsFragmentToMovieDetailsFragment setRating(float rating) {
      this.arguments.put("rating", rating);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTvShowsFragmentToMovieDetailsFragment setId(int id) {
      this.arguments.put("id", id);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("image")) {
        String image = (String) arguments.get("image");
        __result.putString("image", image);
      }
      if (arguments.containsKey("backdrop")) {
        String backdrop = (String) arguments.get("backdrop");
        __result.putString("backdrop", backdrop);
      }
      if (arguments.containsKey("title")) {
        String title = (String) arguments.get("title");
        __result.putString("title", title);
      }
      if (arguments.containsKey("description")) {
        String description = (String) arguments.get("description");
        __result.putString("description", description);
      }
      if (arguments.containsKey("rating")) {
        float rating = (float) arguments.get("rating");
        __result.putFloat("rating", rating);
      }
      if (arguments.containsKey("id")) {
        int id = (int) arguments.get("id");
        __result.putInt("id", id);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_tvShowsFragment_to_movieDetailsFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getImage() {
      return (String) arguments.get("image");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getBackdrop() {
      return (String) arguments.get("backdrop");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getTitle() {
      return (String) arguments.get("title");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getDescription() {
      return (String) arguments.get("description");
    }

    @SuppressWarnings("unchecked")
    public float getRating() {
      return (float) arguments.get("rating");
    }

    @SuppressWarnings("unchecked")
    public int getId() {
      return (int) arguments.get("id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionTvShowsFragmentToMovieDetailsFragment that = (ActionTvShowsFragmentToMovieDetailsFragment) object;
      if (arguments.containsKey("image") != that.arguments.containsKey("image")) {
        return false;
      }
      if (getImage() != null ? !getImage().equals(that.getImage()) : that.getImage() != null) {
        return false;
      }
      if (arguments.containsKey("backdrop") != that.arguments.containsKey("backdrop")) {
        return false;
      }
      if (getBackdrop() != null ? !getBackdrop().equals(that.getBackdrop()) : that.getBackdrop() != null) {
        return false;
      }
      if (arguments.containsKey("title") != that.arguments.containsKey("title")) {
        return false;
      }
      if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) {
        return false;
      }
      if (arguments.containsKey("description") != that.arguments.containsKey("description")) {
        return false;
      }
      if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null) {
        return false;
      }
      if (arguments.containsKey("rating") != that.arguments.containsKey("rating")) {
        return false;
      }
      if (Float.compare(that.getRating(), getRating()) != 0) {
        return false;
      }
      if (arguments.containsKey("id") != that.arguments.containsKey("id")) {
        return false;
      }
      if (getId() != that.getId()) {
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
      result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
      result = 31 * result + (getBackdrop() != null ? getBackdrop().hashCode() : 0);
      result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
      result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
      result = 31 * result + Float.floatToIntBits(getRating());
      result = 31 * result + getId();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionTvShowsFragmentToMovieDetailsFragment(actionId=" + getActionId() + "){"
          + "image=" + getImage()
          + ", backdrop=" + getBackdrop()
          + ", title=" + getTitle()
          + ", description=" + getDescription()
          + ", rating=" + getRating()
          + ", id=" + getId()
          + "}";
    }
  }
}
