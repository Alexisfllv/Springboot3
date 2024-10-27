package com.edu.service;

import com.edu.model.Category;
import com.edu.model.Product;

import java.util.List;

public interface IProductService {

    //metodos

    //metodo de creacion
    Product save(Product product) throws Exception;

    //metodos de lectura
    List<Product> findAll()throws Exception;
    Product findById(Integer id)throws Exception;

    //metodos de actualizacion
    Product update(Integer id ,Product product )throws Exception;

    //metodos de eliminacion
    void delete(Integer id)throws Exception;

    //verificar
    boolean ByidifExist(Integer id)throws Exception;
}
