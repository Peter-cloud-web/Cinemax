// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.di;

import com.example.service.MovieApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideRetrofitFactory implements Factory<MovieApi> {
  @Override
  public MovieApi get() {
    return provideRetrofit();
  }

  public static AppModule_ProvideRetrofitFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MovieApi provideRetrofit() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRetrofit());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideRetrofitFactory INSTANCE = new AppModule_ProvideRetrofitFactory();
  }
}