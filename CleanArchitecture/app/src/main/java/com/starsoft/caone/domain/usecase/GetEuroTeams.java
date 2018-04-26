package com.starsoft.caone.domain.usecase;

import com.starsoft.caone.data.repository.Repository;
import com.starsoft.caone.domain.model.Team;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class GetEuroTeams extends UseCase<List<Team>> {

  private final Repository repository;

  @Inject
  public GetEuroTeams(@Named("executor_thread") Scheduler executorThread,
      @Named("ui_thread") Scheduler uiThread, Repository repository) {
    super(executorThread, uiThread);
    this.repository = repository;
  }

  @Override
  protected Observable<List<Team>> createObservableUseCase() {
    return this.repository.teamList();
  }
}
