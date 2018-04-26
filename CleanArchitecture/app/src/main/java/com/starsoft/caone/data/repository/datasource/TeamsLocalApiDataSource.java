package com.starsoft.caone.data.repository.datasource;

import com.starsoft.caone.data.entity.TeamEntity;
import com.starsoft.caone.data.local.LocalAPI;
import com.starsoft.caone.data.local.LocalImpl;
import io.reactivex.Observable;
import java.util.List;

class TeamsLocalApiDataSource implements DataSource {

  private final LocalAPI localApi;

  public TeamsLocalApiDataSource(LocalAPI localApi) {
    this.localApi = localApi;
  }

  @Override public Observable<List<TeamEntity>> teamEntityList() {
    return this.localApi.teamEntityList();
  }

  @Override public Observable<TeamEntity> teamEntity(String flag) {
    return this.localApi.teamEntity(flag);
  }
}
