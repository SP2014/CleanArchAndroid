package com.starsoft.caone.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import com.starsoft.caone.R;
import com.starsoft.caone.view.presenter.TeamsPresenter;
import com.starsoft.caone.view.viewmodel.TeamViewModel;
import de.hdodenhof.circleimageview.CircleImageView;

public class TeamViewHolder extends RecyclerView.ViewHolder {
  private final TeamsPresenter teamsPresenter;
  @BindView(R.id.image_header) ImageView headerImage;
  @BindView(R.id.image_flag)
  CircleImageView flagImage;
  @BindView(R.id.label_name)
  TextView nameLabel;

  public TeamViewHolder(@NonNull View itemView, @NonNull TeamsPresenter teamsPresenter) {
    super(itemView);
    this.teamsPresenter = teamsPresenter;
    ButterKnife.bind(this, itemView);
  }

  public void render(TeamViewModel team) {
    onItemClick(team);
    renderTeamHeaderImage(team.getPictureOfHeader());
    renderTeamFlagImage(team.getPictureOfFlag());
    renderTeamName(team.getName());
  }

  private void onItemClick(final TeamViewModel teamViewModel) {
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        teamsPresenter.onTeamClicked(teamViewModel);
      }
    });
  }

  private void renderTeamHeaderImage(String urlHeaderImage) {
    getImage(urlHeaderImage, headerImage);
  }

  private void renderTeamFlagImage(String urlFlagImage) {
    getImage(urlFlagImage, flagImage);
  }

  private void renderTeamName(String name) {
    nameLabel.setText(name);
  }

  private void getImage(String photo, ImageView photoImageView) {
    //Picasso.with(getContext()).load(photo).fit().centerCrop().into(photoImageView);
    Picasso.get().load(photo).fit().centerCrop().into(photoImageView);
  }

  private Context getContext() {
    return itemView.getContext();
  }
}
