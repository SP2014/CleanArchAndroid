package com.starsoft.caone.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;
import com.starsoft.caone.data.local.LocalImpl;
import com.starsoft.caone.data.repository.datasource.mapper.TeamEntityJsonMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TeamDataSourceFactory {
  private final Context context;

  @Inject
  public TeamDataSourceFactory(@NonNull Context context) {
    this.context = context;
  }

  public DataSource createDataSource() {
    TeamEntityJsonMapper teamEntityJsonMapper = new TeamEntityJsonMapper();
    LocalImpl local = new LocalImpl(context, teamEntityJsonMapper);
    return new TeamsLocalApiDataSource(local);
  }
}
