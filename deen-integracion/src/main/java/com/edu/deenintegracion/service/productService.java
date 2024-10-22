package com.edu.deenintegracion.service;

import com.edu.deenintegracion.model.Product;
import com.edu.deenintegracion.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class productService {

    //

    private final ProductRepo repo;


    public Product validacionyGuardarProducto(Product product) {
        if (product.getId() == 0){
            //repo = new ProductRepo();
            return repo.saveProduct(product);

        }else {
            return new Product(0,"def",0,false);
        }
    }



}
