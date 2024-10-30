package com.edu.service.impl;

import com.edu.model.Category;
import com.edu.model.Product;
import com.edu.repository.ICategoryRepo;
import com.edu.repository.IGenericJPARepo;
import com.edu.service.ICategoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
}
