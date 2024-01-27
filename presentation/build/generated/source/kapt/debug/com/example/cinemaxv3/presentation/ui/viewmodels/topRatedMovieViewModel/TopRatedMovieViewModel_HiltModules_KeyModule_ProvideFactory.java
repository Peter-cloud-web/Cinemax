// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.view.ui.viewmodels.topRatedMovieViewModel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.internal.lifecycle.HiltViewModelMap.KeySet")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TopRatedMovieViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static TopRatedMovieViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(TopRatedMovieViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final TopRatedMovieViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new TopRatedMovieViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}