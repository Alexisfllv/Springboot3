package com.edu.deenintegracion.repo;

import com.edu.deenintegracion.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {

    public Product saveProduct(Product product) {
        System.out.println("Guardando producto : " + product);
        return product;
    }


   
}
