package com.edu.service.impl.Async;


import com.edu.model.Product;
import com.edu.repository.IProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductNoAsyncServiceImpl {

    //
    private final IProductRepo repo;


    public List<Product> getProducts1() throws InterruptedException {

        //que el proceso demore 1s
        Thread.sleep(1000);


        //listar todos los productos
        List<Product> products = repo.findAll();

        return products;
    }

    public List<Product> getProducts2() throws InterruptedException {

        //que el proceso demore 1s
        Thread.sleep(3000);


        //listar todos los productos
        List<Product> products = repo.findAll();

        return products;
    }

    public List<Product> getProducts3() throws InterruptedException {

        //que el proceso demore 1s
        Thread.sleep(2000);


        //listar todos los productos
        List<Product> products = repo.findAll();

        return products;
    }
}
