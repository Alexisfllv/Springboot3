package com.edu.controller;


import com.edu.model.Product;
import com.edu.service.IProductService;
import com.edu.service.impl.Async.ProductAsyncServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

@RestController
@RequestMapping("/async")
@RequiredArgsConstructor
@Slf4j
public class AsyncController {

    private final ProductAsyncServiceImpl service;

    @GetMapping
    public List<Product> getallProductos() throws InterruptedException, ExecutionException {

        //
        CompletableFuture<List<Product>> c1 = service.getProducts1();
        CompletableFuture<List<Product>> c2 = service.getProducts2();
        CompletableFuture<List<Product>> c3 = service.getProducts3();

        //lg
        log.info("Async request Thread : " +  Thread.currentThread().getName() );

        //procesar los 3
        CompletableFuture.allOf(c1, c2, c3).join();

        //obtener los resultados
        return Stream.of(c1.get(),c2.get(), c3.get())
                .flatMap(Collection::stream)
                .toList();
    }





}
