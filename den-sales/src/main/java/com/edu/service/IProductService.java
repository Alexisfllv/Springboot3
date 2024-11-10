package com.edu.service;

import com.edu.model.Category;
import com.edu.model.Product;
import org.springframework.data.repository.query.Param;

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


    //queries
    //encontrar ciertas palabras en el nombre producto
    List<Product> buscarNombreDentroDeProducto(String palabra);

    //encontrar productos por categoria
    List<Product> buscarProductoPorNombreCategory(String categoryName);

    //encontrar productos por idCategoria
    List<Product> buscarProductoPorIdCategoria(Integer idCategory);

    //encontrar producto por rango de Precios
    List<Product> buscarProductoPorRangoDePrecios(double minimo , double maximo);

    // precios de productos ascedentes
    List<Product> buscarProductosAscedentes();

    //precios de productos descendetes
    List<Product> buscarProductosDescendetes();

    //JPQL
    List<Product> getNameAndDescription1(String name,String desc);

    //2
    List<Product> getNameAndDescription2(String name,String desc);



}
