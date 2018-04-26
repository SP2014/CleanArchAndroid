package com.starsoft.caone.di.components;

import android.content.Context;
import com.starsoft.caone.di.modules.MainModule;
import com.starsoft.caone.view.activity.TeamDetailsActivity;
import com.starsoft.caone.view.activity.TeamsActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = MainModule.class) public interface MainComponent {

  void inject(TeamsActivity activity);

  void inject(TeamDetailsActivity activity);

  Context context();
}