package com.airfrance.testoffer.util;

import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class ObjectMapper {

  private static ModelMapper modelMapper = new ModelMapper();


  public static <D, T> D map(final T entity, Class<D> outClass) {
    if(entity == null){
      return null;
    }
    return modelMapper.map(entity, outClass);
  }

}
