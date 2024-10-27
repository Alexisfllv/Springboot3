package com.edu.controller;

import com.edu.model.Product;
import com.edu.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    //ioc
    private final ProductServiceImpl service;


    @GetMapping
    public List<Product> listAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable ("id") Integer id) throws Exception {
        return  service.findById(id);
    }

}
