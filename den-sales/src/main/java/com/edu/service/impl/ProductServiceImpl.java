package com.edu.service.impl;

import com.edu.model.Category;
import com.edu.model.Product;
import com.edu.repository.IGenericJPARepo;
import com.edu.repository.IProductRepo;
import com.edu.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product,Integer> implements IProductService {

    //ioc
    private final IProductRepo repo;


    @Override
    protected IGenericJPARepo<Product, Integer> getRepo() {
        return repo;
    }
}
