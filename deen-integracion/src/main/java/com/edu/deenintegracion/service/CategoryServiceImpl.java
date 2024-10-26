package com.edu.deenintegracion.service;

import com.edu.deenintegracion.model.Category;
import com.edu.deenintegracion.repo.ICategoryRepo;
import com.edu.deenintegracion.service.impl.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    //instancia del repo categoria
    private final ICategoryRepo categoryRepo;


    //crear
    @Override
    public Category save(Category category) throws Exception {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Integer id, Category category) throws Exception {
        category.setIdCategory(id);
        return  categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() throws Exception {
    return categoryRepo.findAll();
    }

    @Override
    public Category findById(Integer id) throws Exception {
        return categoryRepo.findById(id).orElse(new Category());
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        categoryRepo.deleteById(id);
    }


    //adicional
    @Override
    public boolean existsById(Integer id) throws Exception {
        return categoryRepo.existsById(id);
    }
}
