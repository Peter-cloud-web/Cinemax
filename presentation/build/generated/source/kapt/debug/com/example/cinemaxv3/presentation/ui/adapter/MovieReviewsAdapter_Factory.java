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
public final class MovieReviewsAdapter_Factory implements Factory<MovieReviewsAdapter> {
  private final Provider<ImageLoader> imageLoaderProvider;

  public MovieReviewsAdapter_Factory(Provider<ImageLoader> imageLoaderProvider) {
    this.imageLoaderProvider = imageLoaderProvider;
  }

  @Override
  public MovieReviewsAdapter get() {
    return newInstance(imageLoaderProvider.get());
  }

  public static MovieReviewsAdapter_Factory create(Provider<ImageLoader> imageLoaderProvider) {
    return new MovieReviewsAdapter_Factory(imageLoaderProvider);
  }

  public static MovieReviewsAdapter newInstance(ImageLoader imageLoader) {
    return new MovieReviewsAdapter(imageLoader);
  }
}
