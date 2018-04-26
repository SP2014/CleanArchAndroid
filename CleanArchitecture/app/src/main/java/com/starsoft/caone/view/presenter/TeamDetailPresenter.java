package com.starsoft.caone.view.presenter;

import android.support.annotation.NonNull;
import com.starsoft.caone.domain.model.Team;
import com.starsoft.caone.domain.usecase.GetEuroTeamByFlag;
import com.starsoft.caone.view.viewmodel.TeamViewModel;
import com.starsoft.caone.view.viewmodel.mapper.TeamViewModelToTeamMapper;
import io.reactivex.observers.DisposableObserver;
import javax.inject.Inject;

public class TeamDetailPresenter extends Presenter<TeamDetailPresenter.View> {
  private final GetEuroTeamByFlag getEuroTeamByFlag;
  private final TeamViewModelToTeamMapper mapper;
  private String teamFlag;

  @Inject
  public TeamDetailPresenter(@NonNull GetEuroTeamByFlag getEuroTeamByFlag,
      @NonNull TeamViewModelToTeamMapper mapper) {
    this.getEuroTeamByFlag = getEuroTeamByFlag;
    this.mapper = mapper;
  }

  @SuppressWarnings("unchecked") @Override public void initialize() {
    super.initialize();
    getView().showLoading();
    getEuroTeamByFlag.searchTeamByFlag(teamFlag);
    getEuroTeamByFlag.execute(new DisposableObserver<Team>() {
      @Override public void onComplete() {
        getView().hideLoading();
      }

      @Override public void onError(Throwable e) {
        getView().hideLoading();
      }

      @Override public void onNext(Team team) {
        TeamViewModel teamViewModel = mapper.reverseMap(team);
        getView().showTeam(teamViewModel);
      }
    });
  }

  public void setTeamFlag(String teamFlag) {
    this.teamFlag = teamFlag;
  }

  public void destroy() {
    this.getEuroTeamByFlag.dispose();
    setView(null);
  }

  public interface View extends Presenter.View {
    void showTeam(TeamViewModel teamViewModel);
  }
}
