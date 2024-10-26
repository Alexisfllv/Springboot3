package com.edu.service;

import com.edu.model.Category;

import java.util.List;

public interface ICategoryService {

    //metodos

    //metodo de creacion
    Category save(Category category) throws Exception;

    //metodos de lectura
    List<Category> findAll()throws Exception;
    Category findById(Integer id)throws Exception;

    //metodos de actualizacion
    Category update(Integer id ,Category category )throws Exception;

    //metodos de eliminacion
    void delete(Integer id)throws Exception;

    //verificar
    boolean ByidifExist(Integer id)throws Exception;
}