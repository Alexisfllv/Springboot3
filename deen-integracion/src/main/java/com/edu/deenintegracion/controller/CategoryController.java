package com.edu.deenintegracion.controller;


import com.edu.deenintegracion.model.Category;
import com.edu.deenintegracion.repo.ICategoryRepo;
import com.edu.deenintegracion.service.impl.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;

    @GetMapping("/listar")
    public List<Category> readAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Category readById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) throws Exception {
        return service.save(category);
    }

    @PutMapping("/{id}")
    public Category update (@PathVariable ("id")Integer id , @RequestBody Category category) throws Exception {
        return service.update(id,category);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") Integer id) throws Exception {

        if (service.existsById(id)){
            service.deleteById(id);
            System.out.println("registro eliminado");
        }else {
            System.out.println("no hay registro por eliminar");
        }
    }


}
