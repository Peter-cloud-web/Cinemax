// Generated by Dagger (https://dagger.dev).
package com.example.domain.use_cases.favouritemovies_usecase;

import com.example.framework.repository.MovieRepository;
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
public final class GetFavouriteMovieUseCase_Factory implements Factory<GetFavouriteMovieUseCase> {
  private final Provider<MovieRepository> repositoryProvider;

  public GetFavouriteMovieUseCase_Factory(Provider<MovieRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetFavouriteMovieUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetFavouriteMovieUseCase_Factory create(
      Provider<MovieRepository> repositoryProvider) {
    return new GetFavouriteMovieUseCase_Factory(repositoryProvider);
  }

  public static GetFavouriteMovieUseCase newInstance(MovieRepository repository) {
    return new GetFavouriteMovieUseCase(repository);
  }
}