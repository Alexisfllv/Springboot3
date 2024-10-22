package com.edu.deenintegracion.repo;

import com.edu.deenintegracion.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    public Product saveProduct(Product product) {
        System.out.println("Guardando producto : " + product);
        return product;
    }


   
}
