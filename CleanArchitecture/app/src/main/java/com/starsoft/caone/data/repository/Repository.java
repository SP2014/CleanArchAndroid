package com.starsoft.caone.data.repository;

import com.starsoft.caone.domain.model.Team;
import io.reactivex.Observable;
import java.util.List;

public interface Repository {
  Observable<List<Team>> teamList();

  Observable<Team> team(final String flag);
}
