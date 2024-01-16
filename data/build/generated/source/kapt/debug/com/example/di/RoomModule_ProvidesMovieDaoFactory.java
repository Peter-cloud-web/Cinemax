// Generated by Dagger (https://dagger.dev).
package com.example.di;

import com.example.db.MovieDatabase;
import com.example.db.dao.movieDaos.MovieDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class RoomModule_ProvidesMovieDaoFactory implements Factory<MovieDao> {
  private final Provider<MovieDatabase> databaseProvider;

  public RoomModule_ProvidesMovieDaoFactory(Provider<MovieDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MovieDao get() {
    return ProvidesMovieDao(databaseProvider.get());
  }

  public static RoomModule_ProvidesMovieDaoFactory create(
      Provider<MovieDatabase> databaseProvider) {
    return new RoomModule_ProvidesMovieDaoFactory(databaseProvider);
  }

  public static MovieDao ProvidesMovieDao(MovieDatabase database) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.ProvidesMovieDao(database));
  }
}
