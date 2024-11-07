package com.edu.controller;

import com.edu.dto.ProductDTO;
import com.edu.model.Product;
import com.edu.service.impl.ProductServiceImpl;
import com.edu.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    //ioc
    private final ProductServiceImpl service;

//    @Qualifier("defaultModelMapper")
//    private final ModelMapper modelMapper;
    private final MapperUtil mapperUtil;


//    //modo 3
//    @GetMapping("/listar")
//    public ResponseEntity<List<ProductDTO>> listar() throws Exception {
//          List<ProductDTO> listado = service.findAll()
//                  .stream()
//                  .map(
//                          cat -> convertDto(cat)
//                          //this::convertDto
//                  )
//                  .toList();
//
//        return new ResponseEntity<>(listado,HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) throws Exception {
//        Product buscarid = service.findById(id);
//        return new ResponseEntity<>(convertDto(buscarid), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) throws Exception {
//        Product guardar = service.save(convertEntity(dto));
//        return new ResponseEntity<>(convertDto(guardar), HttpStatus.CREATED);
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ProductDTO> update(@Valid @PathVariable Integer id, @RequestBody ProductDTO dto) throws Exception {
//        Product modificar = service.update(id, convertEntity(dto));
//        return new ResponseEntity<>(convertDto(modificar), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
//        service.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//    //Metodos
//    //convertir a dto
//    private ProductDTO convertDto(Product product) {
//        return modelMapper.map(product,ProductDTO.class);
//    }
//
//    //convertir a entidad
//    private Product convertEntity(ProductDTO dto) {
//        return modelMapper.map(dto,Product.class);
//    }

    //modo 4
    @GetMapping("/listar")
    public ResponseEntity<List<ProductDTO>> listar() throws Exception {
        List<ProductDTO> listado = mapperUtil.mapList(service.findAll(), ProductDTO.class);

        return new ResponseEntity<>(listado,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) throws Exception {
        Product buscarid = service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(buscarid,ProductDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) throws Exception {
        Product guardar = service.save(mapperUtil.map(dto,Product.class));
        return new ResponseEntity<>(mapperUtil.map(guardar,ProductDTO.class), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @PathVariable Integer id, @RequestBody ProductDTO dto) throws Exception {
        Product modificar = service.update(id, mapperUtil.map(dto,Product.class));
        return new ResponseEntity<>(mapperUtil.map(modificar,ProductDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
