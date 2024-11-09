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

    //queries

    @Override
    public List<Product> buscarNombreDentroDeProducto(String palabra) {
        return repo.findByNameContaining(palabra);
    }

    @Override
    public List<Product> buscarProductoPorNombreCategory(String categoryName) {
        return repo.findByCategoryName(categoryName);
    }


    @Override
    public List<Product> buscarProductoPorIdCategoria(Integer idCategory) {
        return repo.findByCategoryIdCategory(idCategory);
    }

    @Override
    public List<Product> buscarProductoPorRangoDePrecios(double minimo, double maximo) {
        return repo.findByPriceBetween(minimo, maximo);
    }

    @Override
    public List<Product> buscarProductosAscedentes() {
        return repo.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> buscarProductosDescendetes() {
        return repo.findAllByOrderByPriceDesc();
    }


}
