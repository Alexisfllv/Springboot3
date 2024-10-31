package com.edu.controller;

import com.edu.model.Category;
import com.edu.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws Exception {
        Category registro =  service.save(category);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    //vista
    @GetMapping("/list")
    public ResponseEntity<List<Category>>  listAllCategory() throws Exception {
        List<Category> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable ("id") Integer id) throws Exception {
        Category buscaid =  service.findById(id);
        return ResponseEntity.ok(buscaid);
    }

    //modificar
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable ("id")Integer id, @RequestBody Category  category) throws Exception {
        Category modificar = service.update(id, category);
        return new ResponseEntity<>(modificar, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id) throws Exception {
        if (service.ByidifExist(id)){
            service.delete(id);
            //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.noContent().build();
            System.out.println("elemento borrado");
        }else {
            System.out.println("elemento no existe");
        }
    }



}
