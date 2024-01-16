// Generated by Dagger (https://dagger.dev).
package com.example.domain.use_cases.popularMovies_usecase;

import com.example.domain.pager.PopularMoviesPager;
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
public final class PopularMoviesUseCase_Factory implements Factory<PopularMoviesUseCase> {
  private final Provider<PopularMoviesPager> popularMoviesPagerProvider;

  public PopularMoviesUseCase_Factory(Provider<PopularMoviesPager> popularMoviesPagerProvider) {
    this.popularMoviesPagerProvider = popularMoviesPagerProvider;
  }

  @Override
  public PopularMoviesUseCase get() {
    return newInstance(popularMoviesPagerProvider.get());
  }

  public static PopularMoviesUseCase_Factory create(
      Provider<PopularMoviesPager> popularMoviesPagerProvider) {
    return new PopularMoviesUseCase_Factory(popularMoviesPagerProvider);
  }

  public static PopularMoviesUseCase newInstance(PopularMoviesPager popularMoviesPager) {
    return new PopularMoviesUseCase(popularMoviesPager);
  }
}