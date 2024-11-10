package com.edu.repository;

import com.edu.model.Category;
import com.edu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //JPQL JAVA PERSISTENCE QUERY LAGNUAGE
    @Query("FROM Product p WHERE p.name = :name AND p.description LIKE %:desc%")
    List<Product> getNameAndDescription1(@Param("name") String name, @Param("desc") String description);

    //para metodos de insert , update y delete
    // @Modifying agregar y retonar un Int que es el numero de filas afectadas

    //mostrar solo filas
    @Query("SELECT new Product ( p.enabled) FROM Product p WHERE p.name = :name AND p.description LIKE %:desc%")
    List<Product> getNameAndDescription2(@Param("name") String name, @Param("desc") String description);

}
