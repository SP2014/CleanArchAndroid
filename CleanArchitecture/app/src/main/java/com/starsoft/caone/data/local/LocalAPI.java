package com.starsoft.caone.data.local;

import com.starsoft.caone.data.entity.TeamEntity;
import io.reactivex.Observable;
import java.util.List;

public interface LocalAPI {

  Observable<List<TeamEntity>> teamEntityList();

  Observable<TeamEntity> teamEntity(final String flag);

}
