// Generated by Dagger (https://dagger.dev).
package com.example.domain.use_cases.searchedMovies_usecase;

import com.example.domain.repository.RemoteMoviesRepository;
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
public final class SearchMoviesUseCase_Factory implements Factory<SearchMoviesUseCase> {
  private final Provider<RemoteMoviesRepository> repositoryProvider;

  public SearchMoviesUseCase_Factory(Provider<RemoteMoviesRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchMoviesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SearchMoviesUseCase_Factory create(
      Provider<RemoteMoviesRepository> repositoryProvider) {
    return new SearchMoviesUseCase_Factory(repositoryProvider);
  }

  public static SearchMoviesUseCase newInstance(RemoteMoviesRepository repository) {
    return new SearchMoviesUseCase(repository);
  }
}