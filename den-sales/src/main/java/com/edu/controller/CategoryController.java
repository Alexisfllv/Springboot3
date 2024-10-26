package com.edu.controller;

import com.edu.model.Category;
import com.edu.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    //ioc
    private final CategoryServiceImpl service;

    //metodos

    //creacion
    @PostMapping
    public Category createCategory(@RequestBody Category category) throws Exception {
        return service.save(category);
    }

    //vista
    @GetMapping("/list")
    public List<Category> listAllCategory() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable ("id") Integer id) throws Exception {
        return service.findById(id);
    }

    //modificar
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable ("id")Integer id, @RequestBody Category  category) throws Exception {
        return service.update(id,category);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Integer id) throws Exception {

        if (service.ByidifExist(id)){
            service.delete(id);
            System.out.println("elemento borrado");
        }else {
            System.out.println("elemento no existe");
        }
    }



}
