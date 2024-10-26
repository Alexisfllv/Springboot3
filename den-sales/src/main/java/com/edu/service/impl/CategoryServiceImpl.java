package com.edu.service.impl;

import com.edu.model.Category;
import com.edu.repository.ICategoryRepo;
import com.edu.service.ICategoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    //ioc repo
    private final ICategoryRepo repo;

    //creacion
    @Override
    public Category save(Category category) throws Exception {
        return repo.save(category);
    }

    //vista
    @Override
    public List<Category> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Category findById(Integer id) throws Exception {
        return repo.findById(id).get();
    }

    //modificar
    @Override
    public Category update(Integer id, Category category) throws Exception {
        category.setIdCategory(id);
        return repo.save(category);
    }

    //eliminar
    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }

    @Override
    public boolean ByidifExist(Integer id) throws Exception {
        return repo.existsById(id);
    }
}
