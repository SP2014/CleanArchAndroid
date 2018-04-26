package com.starsoft.caone.data.repository.datasource.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.starsoft.caone.data.entity.TeamEntity;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import javax.inject.Inject;
import org.json.JSONException;

public class TeamEntityJsonMapper {
  private final Gson gson;

  @Inject public TeamEntityJsonMapper(){
    gson = new Gson();
  }

  public TeamEntity transformTeamEntity(String teamJsonResponse) throws JsonSyntaxException{
    TeamEntity teamEntity;
    try{
      Type typeTeamEntity = new TypeToken<TeamEntity>(){}.getType();
      teamEntity = this.gson.fromJson(teamJsonResponse,typeTeamEntity);
      return teamEntity;
    }catch (JsonSyntaxException exception){
      exception.printStackTrace();
      throw exception;
    }
  }

  public List<TeamEntity> transformTeamEntityCollection(String teamListJsonResponse) throws JsonSyntaxException{
    List<TeamEntity> teamEntityList;
    try{
      Type typeTeamEntityList = new TypeToken<List<TeamEntity>>(){}.getType();
      teamEntityList = this.gson.fromJson(teamListJsonResponse,typeTeamEntityList);
      return teamEntityList;
    }catch (JsonSyntaxException exception){
      exception.printStackTrace();
      throw  exception;
    }
  }

}
