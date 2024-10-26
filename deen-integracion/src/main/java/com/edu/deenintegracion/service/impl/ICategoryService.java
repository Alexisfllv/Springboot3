package com.edu.deenintegracion.service.impl;

import com.edu.deenintegracion.model.Category;

import java.util.List;

public interface ICategoryService {

    //
    //crear
    Category save(Category category) throws Exception;
    //modificar
    Category update(Integer id,  Category category) throws Exception;
    //listar
    List<Category> findAll() throws Exception;
    //buscar por id
    Category findById(Integer id) throws Exception;
    //delete
    void deleteById(Integer id) throws Exception;

    //existe el id
    boolean existsById(Integer id) throws Exception;
}
