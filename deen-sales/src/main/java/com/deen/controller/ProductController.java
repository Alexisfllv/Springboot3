package com.deen.controller;


import com.deen.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    //
    @GetMapping(value = "/producto", produces = MediaType.APPLICATION_XML_VALUE)
    public Product showProduct(){
        return new  Product(1,"Alexis","same",200,true);
    }

    @GetMapping("/productos")
    public List<Product> showProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Alexis","same",200,true));
        products.add(new Product(2,"Alexis","same",200,true));
        products.add(new Product(3,"Alexis","same",200,true));
        return products;
    }

}
