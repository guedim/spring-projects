package org.guedim.externalizeconfig.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class Serializer<T> {
  private final Class<T> clazz;

  public Serializer(Class<T> clazz) {
    this.clazz = clazz;
  }

  public String toJson(T entity) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(entity, entity.getClass());
  }

  public T fromJson(String json) {
    Gson gson = new Gson();
    return gson.fromJson(json, this.clazz);
  }
}
