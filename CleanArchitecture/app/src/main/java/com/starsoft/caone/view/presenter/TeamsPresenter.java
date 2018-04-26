package com.starsoft.caone.view.presenter;

import android.support.annotation.NonNull;
import com.starsoft.caone.domain.model.Team;
import com.starsoft.caone.domain.usecase.GetEuroTeams;
import com.starsoft.caone.view.viewmodel.TeamViewModel;
import com.starsoft.caone.view.viewmodel.mapper.TeamViewModelToTeamMapper;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

public class TeamsPresenter extends Presenter<TeamsPresenter.View> {
  private GetEuroTeams getEuroTeams;
  private TeamViewModelToTeamMapper mapper;

  @Inject
  public TeamsPresenter(@NonNull GetEuroTeams getEuroTeams,
      @NonNull TeamViewModelToTeamMapper mapper) {
    this.getEuroTeams = getEuroTeams;
    this.mapper = mapper;
  }

  @SuppressWarnings("unchecked") @Override public void initialize() {
    super.initialize();
    getView().showLoading();
    getEuroTeams.execute(new DisposableObserver<List<Team>>() {

      @Override public void onNext(List<Team> teams) {
        List<TeamViewModel> teamViewModels = mapper.reverseMap(teams);
        getView().showEuroTeams(teamViewModels);
      }

      @Override public void onError(Throwable e) {
        getView().hideLoading();
        e.printStackTrace();
      }

      @Override public void onComplete() {
        getView().hideLoading();
      }
    });
  }

  public void onTeamClicked(TeamViewModel team) {
    getView().openTeamScreen(team);
  }

  public void destroy() {
    this.getEuroTeams.dispose();
    setView(null);
  }

  public interface View extends Presenter.View {

    void showEuroTeams(List<TeamViewModel> teamList);

    void openTeamScreen(TeamViewModel team);
  }
}
