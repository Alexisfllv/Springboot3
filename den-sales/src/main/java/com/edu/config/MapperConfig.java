package com.edu.config;

import com.edu.dto.CategoryDTO;
import com.edu.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {


    @Bean("defaultModelMapper")
    public ModelMapper defaultModelMapper() {
        return new ModelMapper();
    }

    @Bean("categoryMapper")
    public ModelMapper categoryMapper() {

        ModelMapper modelMapper = new ModelMapper();

        //Handle Missmatches


        //LECTURA
        modelMapper.createTypeMap(Category.class, CategoryDTO.class)
                .addMapping(Category :: getName , (dest, v) -> dest.setNameofCategory((String) v) );

        //ESCRITURA
        modelMapper.createTypeMap(CategoryDTO.class, Category.class)
                .addMapping(CategoryDTO:: getNameofCategory, (dest,v) -> dest.setName((String) v));



        return modelMapper;
    }
}
