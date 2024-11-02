package com.edu.controller;

import com.edu.dto.CategoryDTO;
import com.edu.model.Category;
import com.edu.record.CategoryRecord;
import com.edu.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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

    private final ModelMapper modelMapper;

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
    public ResponseEntity<List<CategoryDTO>> listar() throws Exception {
//        List<CategoryRecord> listado = service.findAll()
//                .stream()
//                .map(
//                        cat -> new CategoryRecord(
//                                cat.getIdCategory(),
//                                cat.getName(),
//                                cat.getDescription(),
//                                cat.isEnabled(),
//                                UUID.randomUUID().toString())
//                )
//                .toList();
//        return new ResponseEntity<>(listado, HttpStatus.OK);

//        List<CategoryDTO> listado =  service.findAll()
//                .stream()
//                .map(
//                        cat -> modelMapper.map(cat,CategoryDTO.class)
//                ).toList();
          List<CategoryDTO> listado = service.findAll()
                  .stream()
                  .map(
                          cat -> convertDto(cat)
                          //this::convertDto
                  )
                  .toList();

        return new ResponseEntity<>(listado,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) throws Exception {
        Category buscarid = service.findById(id);
        return new ResponseEntity<>(convertDto(buscarid), HttpStatus.OK);
    }

    //1
    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) throws Exception {
        Category guardar = service.save(convertEntity(dto));
        return new ResponseEntity<>(convertDto(guardar), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @RequestBody CategoryDTO dto) throws Exception {
        Category modificar = service.update(id, convertEntity(dto));
        return new ResponseEntity<>(convertDto(modificar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //Metodos
    //convertir a dto
    private CategoryDTO convertDto(Category category) {
        return modelMapper.map(category,CategoryDTO.class);
    }

    //convertir a entidad
    private Category convertEntity(CategoryDTO dto) {
        return modelMapper.map(dto,Category.class);
    }



}
