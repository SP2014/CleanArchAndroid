package com.starsoft.caone.data.repository.datasource.mapper;

import com.starsoft.caone.data.entity.TeamEntity;
import com.starsoft.caone.domain.model.Team;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton  public class TeamToTeamEntityMapper extends   Mapper<Team, TeamEntity>  {

  @Inject TeamToTeamEntityMapper(){}


  @Override
  public TeamEntity map(Team value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Team reverseMap(TeamEntity value) {
    Team team = new Team();
    team.setFlag(value.getTeamFlag());
    team.setName(value.getTeamName());
    team.setImageFlag(value.getImages().get(0).getImageFlag());
    team.setImageProfile(value.getImages().get(0).getImageProfile());
    team.setImageHeader(value.getImages().get(0).getImageHeader());
    team.setImageDetail(value.getImages().get(0).getImageDetail());
    team.setDisclaimer(value.getDisclaimer());
    team.setBestResult(value.getBestResult());
    team.setCoach(value.getCoach());
    team.setLeadingScorer(value.getLeadingScorer());
    team.setNickName(value.getNickName());
    team.setStadium(value.getStadium());
    team.setDescriptionPart1(value.getGetdescription1());
    team.setMatchesPlayed(value.getMatchesPlayed());
    team.setOverall(value.getTeamOverall());
    team.setFinalTournament(value.getFinalTournament());
    team.setDescriptionPart2(value.getGetDescription2());
    team.setDescriptionPart3(value.getGetDescription3());
    return team;
  }
}
