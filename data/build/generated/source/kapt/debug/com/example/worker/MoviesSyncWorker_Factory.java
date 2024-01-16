// Generated by Dagger (https://dagger.dev).
package com.example.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
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
public final class MoviesSyncWorker_Factory implements Factory<MoviesSyncWorker> {
  private final Provider<Context> appContextProvider;

  private final Provider<WorkerParameters> workerParamsProvider;

  private final Provider<RemoteMoviesRepository> repositoryProvider;

  private final Provider<MovieDatabase> dbProvider;

  public MoviesSyncWorker_Factory(Provider<Context> appContextProvider,
      Provider<WorkerParameters> workerParamsProvider,
      Provider<RemoteMoviesRepository> repositoryProvider, Provider<MovieDatabase> dbProvider) {
    this.appContextProvider = appContextProvider;
    this.workerParamsProvider = workerParamsProvider;
    this.repositoryProvider = repositoryProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public MoviesSyncWorker get() {
    return newInstance(appContextProvider.get(), workerParamsProvider.get(), repositoryProvider.get(), dbProvider.get());
  }

  public static MoviesSyncWorker_Factory create(Provider<Context> appContextProvider,
      Provider<WorkerParameters> workerParamsProvider,
      Provider<RemoteMoviesRepository> repositoryProvider, Provider<MovieDatabase> dbProvider) {
    return new MoviesSyncWorker_Factory(appContextProvider, workerParamsProvider, repositoryProvider, dbProvider);
  }

  public static MoviesSyncWorker newInstance(Context appContext, WorkerParameters workerParams,
      RemoteMoviesRepository repository, MovieDatabase db) {
    return new MoviesSyncWorker(appContext, workerParams, repository, db);
  }
}