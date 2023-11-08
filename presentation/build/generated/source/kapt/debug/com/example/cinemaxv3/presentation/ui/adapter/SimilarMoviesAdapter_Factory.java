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
public final class SimilarMoviesAdapter_Factory implements Factory<SimilarMoviesAdapter> {
  private final Provider<ImageLoader> imageLoaderProvider;

  public SimilarMoviesAdapter_Factory(Provider<ImageLoader> imageLoaderProvider) {
    this.imageLoaderProvider = imageLoaderProvider;
  }

  @Override
  public SimilarMoviesAdapter get() {
    return newInstance(imageLoaderProvider.get());
  }

  public static SimilarMoviesAdapter_Factory create(Provider<ImageLoader> imageLoaderProvider) {
    return new SimilarMoviesAdapter_Factory(imageLoaderProvider);
  }

  public static SimilarMoviesAdapter newInstance(ImageLoader imageLoader) {
    return new SimilarMoviesAdapter(imageLoader);
  }
}
