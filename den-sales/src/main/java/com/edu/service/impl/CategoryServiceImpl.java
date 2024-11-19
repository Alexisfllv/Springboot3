package com.edu.service.impl;

import com.edu.model.Category;
import com.edu.model.Product;
import com.edu.repository.ICategoryRepo;
import com.edu.repository.IGenericJPARepo;
import com.edu.service.ICategoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  extends CRUDImpl<Category,Integer> implements ICategoryService {

    //repo
    private final ICategoryRepo repo;

    @Override
    protected IGenericJPARepo<Category, Integer> getRepo() {
        return repo;
    }

    //METODO QUERIES
    @Override
    public List<Category> buscarNombreCategory(String categoryName) {
        return repo.findByName(categoryName);
    }

    ///pages
    ///
    @Override
    public Page<Category> buscarCategorias(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Category> findAllOrder(String param) {
        Sort.Direction direction= param.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return repo.findAll(Sort.by(direction,"name"));
    }
}
