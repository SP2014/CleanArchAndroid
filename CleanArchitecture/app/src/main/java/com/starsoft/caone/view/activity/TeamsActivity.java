package com.starsoft.caone.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.starsoft.caone.CAOne;
import com.starsoft.caone.R;
import com.starsoft.caone.view.adapter.TeamsAdapter;
import com.starsoft.caone.view.base.BaseActivity;
import com.starsoft.caone.view.presenter.TeamsPresenter;
import com.starsoft.caone.view.viewmodel.TeamViewModel;
import java.util.List;
import javax.inject.Inject;

public class TeamsActivity extends BaseActivity implements TeamsPresenter.View {
  @Inject
  TeamsPresenter presenter;
  @BindView(R.id.list_teams)
  RecyclerView teamList;
  @BindView(R.id.progress_team)
  ProgressBar teamProgress;
  private TeamsAdapter adapter;

  @Override public void initView() {
    super.initView();
    initializeDagger();
    initializePresenter();
    disableTitleFromToolbar();
    initializeAdapter();
    initializeRecyclerView();
    presenter.initialize();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_teams;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.destroy();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_scrolling, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.action_code) {
      final String repositoryURL = "https://github.com/erikcaffrey/Clean-Architecture-Android";
      startActivityActionView(repositoryURL);
    } else {
      String blogURL = "https://erikcaffrey.github.io/ANDROID-clean-architecture/";
      startActivityActionView(blogURL);
    }

    return super.onOptionsItemSelected(item);
  }

  @Override public void showEuroTeams(List<TeamViewModel> teamList) {
    adapter.addAll(teamList);
    adapter.notifyDataSetChanged();
  }

  @Override public void openTeamScreen(TeamViewModel team) {
    TeamDetailsActivity.open(TeamsActivity.this, team.getFlag());
  }

  @Override public void showLoading() {
    teamProgress.setVisibility(View.VISIBLE);
    teamList.setVisibility(View.GONE);
  }

  @Override public void hideLoading() {
    teamProgress.setVisibility(View.GONE);
    teamList.setVisibility(View.VISIBLE);
  }

  private void initializeAdapter() {
    adapter = new TeamsAdapter(presenter);
  }

  private void initializeRecyclerView() {
    teamList.setLayoutManager(new LinearLayoutManager(this));
    teamList.addItemDecoration(new android.support.v7.widget.DividerItemDecoration(this,
        android.support.v7.widget.DividerItemDecoration.VERTICAL));
    teamList.setHasFixedSize(true);
    teamList.setAdapter(adapter);
  }

  private void initializeDagger() {
    CAOne app = (CAOne) getApplication();
    app.getMainComponent().inject(this);
  }

  private void initializePresenter() {
    presenter.setView(this);
  }

  private void disableTitleFromToolbar() {
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
  }

  private void startActivityActionView(String url) {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
  }
}
