package com.edu.service.impl;

import com.edu.model.Category;
import com.edu.model.Product;
import com.edu.repository.IProductRepo;
import com.edu.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    //ioc
    private final IProductRepo repo;


    @Override
    public Product save(Product product) throws Exception {
        return repo.save(product);
    }

    @Override
    public List<Product> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Product findById(Integer id) throws Exception {
        return repo.findById(id).get();
    }

    @Override
    public Product update(Integer id, Product product) throws Exception {
        product.setIdProduct(id);
        return repo.save(product);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }

    @Override
    public boolean ByidifExist(Integer id) throws Exception {
        return repo.existsById(id);
    }
}
