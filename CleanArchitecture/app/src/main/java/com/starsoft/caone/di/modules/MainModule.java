package com.starsoft.caone.di.modules;

import android.content.Context;
import com.starsoft.caone.CAOne;
import com.starsoft.caone.data.repository.Repository;
import com.starsoft.caone.data.repository.TeamsRepository;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

@Module public class MainModule {
  private final CAOne euroApplication;

  public MainModule(CAOne euroApplication) {
    this.euroApplication = euroApplication;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return euroApplication;
  }

  @Provides @Singleton
  Repository provideRepository(TeamsRepository teamsRepository) {
    return teamsRepository;
  }

  @Provides @Named("executor_thread")
  Scheduler provideExecutorThread() {
    return Schedulers.io();
  }

  @Provides @Named("ui_thread") Scheduler provideUiThread() {
    return AndroidSchedulers.mainThread();
  }
}
