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
public final class SharedTvShowsAdapter_Factory implements Factory<SharedTvShowsAdapter> {
  private final Provider<ImageLoader> imageLoaderProvider;

  public SharedTvShowsAdapter_Factory(Provider<ImageLoader> imageLoaderProvider) {
    this.imageLoaderProvider = imageLoaderProvider;
  }

  @Override
  public SharedTvShowsAdapter get() {
    return newInstance(imageLoaderProvider.get());
  }

  public static SharedTvShowsAdapter_Factory create(Provider<ImageLoader> imageLoaderProvider) {
    return new SharedTvShowsAdapter_Factory(imageLoaderProvider);
  }

  public static SharedTvShowsAdapter newInstance(ImageLoader imageLoader) {
    return new SharedTvShowsAdapter(imageLoader);
  }
}