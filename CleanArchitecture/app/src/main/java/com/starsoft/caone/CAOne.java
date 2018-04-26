package com.starsoft.caone;

import android.app.Application;
import com.starsoft.caone.di.components.DaggerMainComponent;
import com.starsoft.caone.di.components.MainComponent;
import com.starsoft.caone.di.modules.MainModule;

public class CAOne extends Application {
  private MainComponent mainComponent;
  @Override
  public void onCreate() {
    super.onCreate();
    initializeInjector();
  }
  private void initializeInjector() {
    mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
  }

  public MainComponent getMainComponent() {
    return mainComponent;
  }
}
