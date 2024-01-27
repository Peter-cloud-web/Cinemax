// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.view.ui.adapter;

import coil.ImageLoader;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UpComingMoviesAdapter_Factory implements Factory<UpComingMoviesAdapter> {
  private final Provider<ImageLoader> imageLoaderProvider;

  public UpComingMoviesAdapter_Factory(Provider<ImageLoader> imageLoaderProvider) {
    this.imageLoaderProvider = imageLoaderProvider;
  }

  @Override
  public UpComingMoviesAdapter get() {
    return newInstance(imageLoaderProvider.get());
  }

  public static UpComingMoviesAdapter_Factory create(Provider<ImageLoader> imageLoaderProvider) {
    return new UpComingMoviesAdapter_Factory(imageLoaderProvider);
  }

  public static UpComingMoviesAdapter newInstance(ImageLoader imageLoader) {
    return new UpComingMoviesAdapter(imageLoader);
  }
}