package com.example.cinemaxv3.presentation.ui.viewmodels.popularTvShowViewModel;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;
import java.lang.String;

@OriginatingElement(
    topLevelClass = PopularTvShowViewModel.class
)
public final class PopularTvShowViewModel_HiltModules {
  private PopularTvShowViewModel_HiltModules() {
  }

  @Module
  @InstallIn(ViewModelComponent.class)
  public abstract static class BindsModule {
    private BindsModule() {
    }

    @Binds
    @IntoMap
    @StringKey("com.example.cinemaxv3.presentation.ui.viewmodels.popularTvShowViewModel.PopularTvShowViewModel")
    @HiltViewModelMap
    public abstract ViewModel binds(PopularTvShowViewModel vm);
  }

  @Module
  @InstallIn(ActivityRetainedComponent.class)
  public static final class KeyModule {
    private KeyModule() {
    }

    @Provides
    @IntoSet
    @HiltViewModelMap.KeySet
    public static String provide() {
      return "com.example.cinemaxv3.presentation.ui.viewmodels.popularTvShowViewModel.PopularTvShowViewModel";
    }
  }
}
