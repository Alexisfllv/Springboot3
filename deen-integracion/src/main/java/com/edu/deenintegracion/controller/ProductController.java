package com.edu.deenintegracion.controller;

import com.edu.deenintegracion.model.Product;
import com.edu.deenintegracion.service.productService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products") //SIEMPRE PLURAL
@RequiredArgsConstructor
public class ProductController {

    //
//    @GetMapping
//    public Product retornoProduct(){
//        return new Product(1,"same",20,true);
//    }

    //
    private final productService service;

    private int numero;

    @GetMapping
    public Product saveProduct(){
        //service = new productService();
        return service.validacionyGuardarProducto(new Product(0,"kik",10,true));

    }

}
