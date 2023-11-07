package com.example.cinemaxv3;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = MovieApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface MovieApp_GeneratedInjector {
  void injectMovieApp(MovieApp movieApp);
}
