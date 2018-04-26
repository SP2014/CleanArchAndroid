package com.starsoft.caone.data.repository.datasource;

import com.starsoft.caone.data.entity.TeamEntity;
import io.reactivex.Observable;
import java.util.List;

public interface DataSource {
  Observable<List<TeamEntity>> teamEntityList();

  Observable<TeamEntity> teamEntity(final String flag);
}
