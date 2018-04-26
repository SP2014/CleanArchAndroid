package com.starsoft.caone.data.local;

import android.content.Context;
import com.starsoft.caone.data.entity.TeamEntity;
import com.starsoft.caone.data.repository.datasource.mapper.TeamEntityJsonMapper;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class LocalImpl implements LocalAPI {

  private final Context context;
  private TeamEntityJsonMapper teamEntityJsonMapper;

  public LocalImpl(@NonNull Context context, @NonNull TeamEntityJsonMapper jsonMapper) {
    this.context = context;
    this.teamEntityJsonMapper = jsonMapper;
  }

  @Override
  public Observable<List<TeamEntity>> teamEntityList() {
    return Observable.create(emmiter->{
      List<TeamEntity> teamEntityList = getAll();
      if(teamEntityList!=null){
        emmiter.onNext(teamEntityList);
        emmiter.onComplete();
      }else{
        emmiter.onError(new Throwable("Error getting team data list from local storage"));
      }
    });
  }

  @Override
  public Observable<TeamEntity> teamEntity(final String flag) {
    return Observable.create(emmiter->{
      TeamEntity teamEntity = getByFlag(flag);
      if(teamEntity!=null){
        emmiter.onNext(teamEntity);
        emmiter.onComplete();
      }else{
        emmiter.onError(new Throwable("Error getting team data from local list"));
      }
    });
  }

  private List<TeamEntity> getAll(){
    return teamEntityJsonMapper.transformTeamEntityCollection(getResponseFromLocalJson());
  }

  private TeamEntity getByFlag(String flag){
    TeamEntity result = null;
    for(TeamEntity t:getAll()){
      if(t.getTeamFlag().equals(flag)){
        result = t;
        break;
      }
    }
    return result;
  }

  private String getResponseFromLocalJson(){
    final String EURO_DATA_FILE = "euro_data.json";
    String str = "";
    try{
      StringBuilder builder = new StringBuilder();
      InputStream json = context.getAssets().open(EURO_DATA_FILE);
      BufferedReader br = new BufferedReader(new InputStreamReader(json));
      while ((str = br.readLine())!=null){
        builder.append(str);
      }
      br.close();
      str = builder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }


}
