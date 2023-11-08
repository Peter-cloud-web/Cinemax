// Generated by Dagger (https://dagger.dev).
package com.example.cinemaxv3.view.ui.viewmodels.searchedMoviesViewModel;

import com.example.domain.use_cases.searchedMovies_usecase.SearchMoviesUseCase;
import com.example.service.MovieApi;
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
public final class SearchedMoviesViewModel_Factory implements Factory<SearchedMoviesViewModel> {
  private final Provider<SearchMoviesUseCase> searchMoviesUseCaseProvider;

  private final Provider<MovieApi> apiProvider;

  public SearchedMoviesViewModel_Factory(Provider<SearchMoviesUseCase> searchMoviesUseCaseProvider,
      Provider<MovieApi> apiProvider) {
    this.searchMoviesUseCaseProvider = searchMoviesUseCaseProvider;
    this.apiProvider = apiProvider;
  }

  @Override
  public SearchedMoviesViewModel get() {
    return newInstance(searchMoviesUseCaseProvider.get(), apiProvider.get());
  }

  public static SearchedMoviesViewModel_Factory create(
      Provider<SearchMoviesUseCase> searchMoviesUseCaseProvider, Provider<MovieApi> apiProvider) {
    return new SearchedMoviesViewModel_Factory(searchMoviesUseCaseProvider, apiProvider);
  }

  public static SearchedMoviesViewModel newInstance(SearchMoviesUseCase searchMoviesUseCase,
      MovieApi api) {
    return new SearchedMoviesViewModel(searchMoviesUseCase, api);
  }
}
