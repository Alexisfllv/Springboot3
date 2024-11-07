package com.edu.util;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor //ioc
public class MapperUtil {

    private final ApplicationContext applicationContext;


    //para una lista
    public <S,T> List<T> mapList(List<S> source , Class<T> targetClass, String... mapperQualifier){
        ModelMapper modelMapper = getModelmapper(mapperQualifier);
        return source
                .stream()
                .map(element -> modelMapper.map(element,targetClass))
                .toList();

    }
    //para conversion de elemento

    public <S,T> T map(S source,Class<T> targetClass, String... mapperQualifier) {
            ModelMapper modelMapper = getModelmapper(mapperQualifier);
            return modelMapper.map(source, targetClass);
    }
    //identificar el model usado
    private ModelMapper getModelmapper(String ... mapQualifier){
        if (mapQualifier.length == 0 || mapQualifier[0] == null || mapQualifier[0].isEmpty()){
            return applicationContext.getBean("defaultModelMapper", ModelMapper.class);
        }else {
            return applicationContext.getBean(mapQualifier[0], ModelMapper.class);
        }

    }

}
