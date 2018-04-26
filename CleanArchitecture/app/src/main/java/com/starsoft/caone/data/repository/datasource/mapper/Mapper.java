package com.starsoft.caone.data.repository.datasource.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<T1, T2> {

  public abstract T2 map(T1 value);
  public abstract T1 reverseMap(T2 value);

  public List<T2> map(List<T1> values){
    List<T2> returnValues = new ArrayList<>(values.size());
    for(T1 val:values){
      returnValues.add(map(val));
    }
    return returnValues;
  }

  public List<T1> reverseMap(List<T2> values){
    List<T1> returnValues = new ArrayList<>(values.size());
    for (T2 val:values){
      returnValues.add(reverseMap(val));
    }
    return returnValues;
  }
}
