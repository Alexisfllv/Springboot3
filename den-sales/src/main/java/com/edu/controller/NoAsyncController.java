package com.edu.controller;


import com.edu.model.Product;
import com.edu.service.IProductService;
import com.edu.service.impl.Async.ProductAsyncServiceImpl;
import com.edu.service.impl.Async.ProductNoAsyncServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/noasync")
@RequiredArgsConstructor
public class NoAsyncController {

    private final ProductNoAsyncServiceImpl service;


    @GetMapping()
    public List<Product> getAllProduct() throws InterruptedException {
        List<Product> lista1 = service.getProducts1();
        List<Product> lista2 = service.getProducts2();
        List<Product> lista3 = service.getProducts3();
        //
        List<Product> lista4 = new ArrayList(lista1);
        lista4.addAll(lista2);
        lista4.addAll(lista3);

        return lista4;
    }

}
