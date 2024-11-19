package com.edu.service;

import com.edu.model.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends  ICRUD<Category,Integer> {



    //definir el metodo
    List<Category> buscarNombreCategory(String categoryName);

    //SPRING DATA

    // pageable
    Page<Category> buscarCategorias(Pageable pageable);

    //lista de categorias ordenadas
    List<Category> findAllOrder(String param);
}