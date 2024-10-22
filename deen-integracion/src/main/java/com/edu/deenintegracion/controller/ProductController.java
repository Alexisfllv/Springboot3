package com.edu.deenintegracion.controller;

import com.edu.deenintegracion.model.Product;
import com.edu.deenintegracion.service.productService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products") //SIEMPRE PLURAL
public class ProductController {

    //
//    @GetMapping
//    public Product retornoProduct(){
//        return new Product(1,"same",20,true);
//    }

    private productService service;

    @GetMapping
    public Product saveProduct(){
        service = new productService();
        return service.validacionyGuardarProducto(new Product(0,"kik",10,true));

    }

}
