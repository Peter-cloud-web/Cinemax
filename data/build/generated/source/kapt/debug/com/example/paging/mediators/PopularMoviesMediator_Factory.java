// Generated by Dagger (https://dagger.dev).
package com.example.paging.mediators;

import com.example.db.MovieDatabase;
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
public final class PopularMoviesMediator_Factory implements Factory<PopularMoviesMediator> {
  private final Provider<MovieDatabase> dbProvider;

  private final Provider<RemoteMoviesRepository> repositoryProvider;

  public PopularMoviesMediator_Factory(Provider<MovieDatabase> dbProvider,
      Provider<RemoteMoviesRepository> repositoryProvider) {
    this.dbProvider = dbProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PopularMoviesMediator get() {
    return newInstance(dbProvider.get(), repositoryProvider.get());
  }

  public static PopularMoviesMediator_Factory create(Provider<MovieDatabase> dbProvider,
      Provider<RemoteMoviesRepository> repositoryProvider) {
    return new PopularMoviesMediator_Factory(dbProvider, repositoryProvider);
  }

  public static PopularMoviesMediator newInstance(MovieDatabase db,
      RemoteMoviesRepository repository) {
    return new PopularMoviesMediator(db, repository);
  }
}