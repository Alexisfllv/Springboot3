package com.edu.controller;

import com.edu.dto.CategoryDTO;
import com.edu.model.Category;
import com.edu.record.CategoryRecord;
import com.edu.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    //ioc
    private final CategoryServiceImpl service;

    //metodos

    //Modo 2

    //creacion
//    @PostMapping
//    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws Exception {
//        Category registro =  service.save(category);
//        return new ResponseEntity<>(registro, HttpStatus.CREATED);
//    }
//
//    //vista
//    @GetMapping("/list")
//    public ResponseEntity<List<Category>>  listAllCategory() throws Exception {
//        List<Category> list = service.findAll();
//        return ResponseEntity.ok(list);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Category> findById(@PathVariable ("id") Integer id) throws Exception {
//        Category buscaid =  service.findById(id);
//        return ResponseEntity.ok(buscaid);
//    }
//
//    //modificar
//    @PutMapping("/{id}")
//    public ResponseEntity<Category> updateCategory(@PathVariable ("id")Integer id, @RequestBody Category  category) throws Exception {
//        Category modificar = service.update(id, category);
//        return new ResponseEntity<>(modificar, HttpStatus.OK);
//    }
//
//    //delete
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id) throws Exception {
//        if (service.ByidifExist(id)){
//            service.delete(id);
//            System.out.println("elemento borrado");
//            return new ResponseEntity<>(HttpStatus.OK);
//            //return ResponseEntity.noContent().build();
//
//        }else {
//            System.out.println("elemento no existe");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//    }

    //modo 3
    @GetMapping("/listar")
    public ResponseEntity<List<CategoryRecord>> listar() throws Exception {
        List<CategoryRecord> listado = service.findAll()
                .stream()
                .map(
                        cat -> new CategoryRecord(
                                cat.getIdCategory(),
                                cat.getName(),
                                cat.getDescription(),
                                cat.isEnabled(),
                                UUID.randomUUID().toString())
                )
                .toList();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) throws Exception {
        Category buscarid = service.findById(id);
        return new ResponseEntity<>(buscarid, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category category) throws Exception {
        Category guardar = service.save(category);
        return new ResponseEntity<>(guardar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category) throws Exception {
        Category modificar = service.update(id, category);
        return new ResponseEntity<>(modificar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
