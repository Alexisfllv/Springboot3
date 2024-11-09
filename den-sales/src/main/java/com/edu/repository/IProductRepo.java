package com.edu.repository;

import com.edu.model.Category;
import com.edu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepo extends IGenericJPARepo<Product, Integer> {


    //queries

    // Encontrar productos que contienen cierta palabra en el nombre
    List<Product> findByNameContaining(String keyword);

    // Encontrar productos por categoria
    List<Product> findByCategoryName(String categoryName);

    // Encontrar productos por ID de categoria
    List<Product> findByCategoryIdCategory(Integer idCategory);

    // Encontrar productos por rango de precios
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    // Encontrar por Precio ascedente
    List<Product> findAllByOrderByPriceAsc();

    // Listar por precio descendente
    List<Product> findAllByOrderByPriceDesc();

}
