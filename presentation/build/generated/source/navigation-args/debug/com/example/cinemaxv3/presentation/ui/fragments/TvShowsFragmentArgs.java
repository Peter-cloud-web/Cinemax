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

public class TvShowsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private TvShowsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private TvShowsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TvShowsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    TvShowsFragmentArgs __result = new TvShowsFragmentArgs();
    bundle.setClassLoader(TvShowsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("TvShowsFragmentArgs")) {
      String TvShowsFragmentArgs;
      TvShowsFragmentArgs = bundle.getString("TvShowsFragmentArgs");
      if (TvShowsFragmentArgs == null) {
        throw new IllegalArgumentException("Argument \"TvShowsFragmentArgs\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("TvShowsFragmentArgs", TvShowsFragmentArgs);
    } else {
      throw new IllegalArgumentException("Required argument \"TvShowsFragmentArgs\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TvShowsFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    TvShowsFragmentArgs __result = new TvShowsFragmentArgs();
    if (savedStateHandle.contains("TvShowsFragmentArgs")) {
      String TvShowsFragmentArgs;
      TvShowsFragmentArgs = savedStateHandle.get("TvShowsFragmentArgs");
      if (TvShowsFragmentArgs == null) {
        throw new IllegalArgumentException("Argument \"TvShowsFragmentArgs\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("TvShowsFragmentArgs", TvShowsFragmentArgs);
    } else {
      throw new IllegalArgumentException("Required argument \"TvShowsFragmentArgs\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getTvShowsFragmentArgs() {
    return (String) arguments.get("TvShowsFragmentArgs");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("TvShowsFragmentArgs")) {
      String TvShowsFragmentArgs = (String) arguments.get("TvShowsFragmentArgs");
      __result.putString("TvShowsFragmentArgs", TvShowsFragmentArgs);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("TvShowsFragmentArgs")) {
      String TvShowsFragmentArgs = (String) arguments.get("TvShowsFragmentArgs");
      __result.set("TvShowsFragmentArgs", TvShowsFragmentArgs);
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
    TvShowsFragmentArgs that = (TvShowsFragmentArgs) object;
    if (arguments.containsKey("TvShowsFragmentArgs") != that.arguments.containsKey("TvShowsFragmentArgs")) {
      return false;
    }
    if (getTvShowsFragmentArgs() != null ? !getTvShowsFragmentArgs().equals(that.getTvShowsFragmentArgs()) : that.getTvShowsFragmentArgs() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getTvShowsFragmentArgs() != null ? getTvShowsFragmentArgs().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TvShowsFragmentArgs{"
        + "TvShowsFragmentArgs=" + getTvShowsFragmentArgs()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull TvShowsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String TvShowsFragmentArgs) {
      if (TvShowsFragmentArgs == null) {
        throw new IllegalArgumentException("Argument \"TvShowsFragmentArgs\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("TvShowsFragmentArgs", TvShowsFragmentArgs);
    }

    @NonNull
    public TvShowsFragmentArgs build() {
      TvShowsFragmentArgs result = new TvShowsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setTvShowsFragmentArgs(@NonNull String TvShowsFragmentArgs) {
      if (TvShowsFragmentArgs == null) {
        throw new IllegalArgumentException("Argument \"TvShowsFragmentArgs\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("TvShowsFragmentArgs", TvShowsFragmentArgs);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getTvShowsFragmentArgs() {
      return (String) arguments.get("TvShowsFragmentArgs");
    }
  }
}
