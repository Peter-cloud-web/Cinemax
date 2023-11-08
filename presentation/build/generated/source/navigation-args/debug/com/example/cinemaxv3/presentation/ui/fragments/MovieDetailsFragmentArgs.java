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

public class MovieDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private MovieDetailsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private MovieDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MovieDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    MovieDetailsFragmentArgs __result = new MovieDetailsFragmentArgs();
    bundle.setClassLoader(MovieDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("image")) {
      String image;
      image = bundle.getString("image");
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("image", image);
    } else {
      throw new IllegalArgumentException("Required argument \"image\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("backdrop")) {
      String backdrop;
      backdrop = bundle.getString("backdrop");
      if (backdrop == null) {
        throw new IllegalArgumentException("Argument \"backdrop\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("backdrop", backdrop);
    } else {
      throw new IllegalArgumentException("Required argument \"backdrop\" is missing and does not have an android:defaultValue");
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
    if (bundle.containsKey("description")) {
      String description;
      description = bundle.getString("description");
      if (description == null) {
        throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("description", description);
    } else {
      throw new IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("rating")) {
      float rating;
      rating = bundle.getFloat("rating");
      __result.arguments.put("rating", rating);
    } else {
      throw new IllegalArgumentException("Required argument \"rating\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("id")) {
      int id;
      id = bundle.getInt("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static MovieDetailsFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    MovieDetailsFragmentArgs __result = new MovieDetailsFragmentArgs();
    if (savedStateHandle.contains("image")) {
      String image;
      image = savedStateHandle.get("image");
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("image", image);
    } else {
      throw new IllegalArgumentException("Required argument \"image\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("backdrop")) {
      String backdrop;
      backdrop = savedStateHandle.get("backdrop");
      if (backdrop == null) {
        throw new IllegalArgumentException("Argument \"backdrop\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("backdrop", backdrop);
    } else {
      throw new IllegalArgumentException("Required argument \"backdrop\" is missing and does not have an android:defaultValue");
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
    if (savedStateHandle.contains("description")) {
      String description;
      description = savedStateHandle.get("description");
      if (description == null) {
        throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("description", description);
    } else {
      throw new IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("rating")) {
      float rating;
      rating = savedStateHandle.get("rating");
      __result.arguments.put("rating", rating);
    } else {
      throw new IllegalArgumentException("Required argument \"rating\" is missing and does not have an android:defaultValue");
    }
    if (savedStateHandle.contains("id")) {
      int id;
      id = savedStateHandle.get("id");
      __result.arguments.put("id", id);
    } else {
      throw new IllegalArgumentException("Required argument \"id\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("image")) {
      String image = (String) arguments.get("image");
      __result.set("image", image);
    }
    if (arguments.containsKey("backdrop")) {
      String backdrop = (String) arguments.get("backdrop");
      __result.set("backdrop", backdrop);
    }
    if (arguments.containsKey("title")) {
      String title = (String) arguments.get("title");
      __result.set("title", title);
    }
    if (arguments.containsKey("description")) {
      String description = (String) arguments.get("description");
      __result.set("description", description);
    }
    if (arguments.containsKey("rating")) {
      float rating = (float) arguments.get("rating");
      __result.set("rating", rating);
    }
    if (arguments.containsKey("id")) {
      int id = (int) arguments.get("id");
      __result.set("id", id);
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
    MovieDetailsFragmentArgs that = (MovieDetailsFragmentArgs) object;
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
    return result;
  }

  @Override
  public String toString() {
    return "MovieDetailsFragmentArgs{"
        + "image=" + getImage()
        + ", backdrop=" + getBackdrop()
        + ", title=" + getTitle()
        + ", description=" + getDescription()
        + ", rating=" + getRating()
        + ", id=" + getId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull MovieDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String image, @NonNull String backdrop, @NonNull String title,
        @NonNull String description, float rating, int id) {
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
    public MovieDetailsFragmentArgs build() {
      MovieDetailsFragmentArgs result = new MovieDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setImage(@NonNull String image) {
      if (image == null) {
        throw new IllegalArgumentException("Argument \"image\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("image", image);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setBackdrop(@NonNull String backdrop) {
      if (backdrop == null) {
        throw new IllegalArgumentException("Argument \"backdrop\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("backdrop", backdrop);
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

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setDescription(@NonNull String description) {
      if (description == null) {
        throw new IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("description", description);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setRating(float rating) {
      this.arguments.put("rating", rating);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setId(int id) {
      this.arguments.put("id", id);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getImage() {
      return (String) arguments.get("image");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getBackdrop() {
      return (String) arguments.get("backdrop");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getTitle() {
      return (String) arguments.get("title");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getDescription() {
      return (String) arguments.get("description");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public float getRating() {
      return (float) arguments.get("rating");
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public int getId() {
      return (int) arguments.get("id");
    }
  }
}
