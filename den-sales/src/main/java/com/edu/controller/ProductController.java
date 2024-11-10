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
    public ResponseEntity<ProductDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ProductDTO dto) throws Exception {
        Product modificar = service.update(id, mapperUtil.map(dto,Product.class));
        return new ResponseEntity<>(mapperUtil.map(modificar,ProductDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //queries
    //BUSCAR POR PALABRA DENTRO DE NOMBRE PRODUCTO
    @GetMapping("/buscar/palabra/{palabra}")
    public ResponseEntity<List<ProductDTO>> findByPalabra(@PathVariable String palabra) throws Exception {
        List<ProductDTO> busquedaPalabra = mapperUtil.mapList(service.buscarNombreDentroDeProducto(palabra),ProductDTO.class);
        return new ResponseEntity<>(busquedaPalabra,HttpStatus.OK);
    }

    //ENCONTRAR PRODUCTOS POR NOMBRE NOMBRE CATEGORIA
    @GetMapping("/encontrar/categoryNombre/{categoriaNombre}")
    public ResponseEntity<List<ProductDTO>> buscarCategoriaNombre(@PathVariable String categoriaNombre) throws Exception {
        List<ProductDTO> productoxnombreCategory = mapperUtil.mapList(service.buscarProductoPorNombreCategory(categoriaNombre),ProductDTO.class);
        return new ResponseEntity<>(productoxnombreCategory,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        return service.buscarProductoPorNombreCategory(categoryName);
    }

    //ENCONTRAR PRODUCTOS POR ID CATEGORIA
    @GetMapping("/encontrar/categoryId/{categoryId}")
    public ResponseEntity<List<ProductDTO>> buscarPorIdCategory(@PathVariable Integer categoryId) throws Exception {
        List<ProductDTO> idCategory = mapperUtil.mapList(service.buscarProductoPorIdCategoria(categoryId),ProductDTO.class);
        return new ResponseEntity<>(idCategory,HttpStatus.OK);
    }

    //BUSCAR PRODUCTO POR RANGO DE PRECIOS MINIMO/MAXIMO
    @GetMapping("/encontrar/rango")
    public ResponseEntity<List<ProductDTO>> rangoPrecios(@RequestParam("minimo") Integer minimo, @RequestParam("maximo") Integer maximo) throws Exception {
        List<ProductDTO> rangoPrecios = mapperUtil.mapList(service.buscarProductoPorRangoDePrecios(minimo, maximo),ProductDTO.class);
        return new ResponseEntity<>(rangoPrecios,HttpStatus.OK);
    }

    //LISTADO DE PRECIOS PRODUCTOS EN ASCEDENTE
    @GetMapping("/listar/ascendete")
    public ResponseEntity<List<ProductDTO>> listarAscendente() throws Exception {
        List<ProductDTO> listado = mapperUtil.mapList(service.buscarProductosAscedentes(), ProductDTO.class);
        return new ResponseEntity<>(listado,HttpStatus.OK);
    }

    //LISTADO DE PRECIOS PRODUCTOS EN DESCENDETENS
    @GetMapping("/listar/descendente")
    public ResponseEntity<List<ProductDTO>> listarDescendente() throws Exception {
        List<ProductDTO> listado = mapperUtil.mapList(service.buscarProductosDescendetes(), ProductDTO.class);
        return new ResponseEntity<>(listado,HttpStatus.OK);
    }

    //JPLQ
    //BUSCAR POR NOMBRE Y DESCRIPCION
    @GetMapping("/buscar/nombredesc")
    public ResponseEntity<List<ProductDTO>> buscarNombreDesc(@RequestParam("name") String name , @RequestParam ("desc") String desc ) throws Exception {
        List<ProductDTO> nombredesc = mapperUtil.mapList(service.getNameAndDescription1(name,desc),ProductDTO.class);
        return new ResponseEntity<>(nombredesc,HttpStatus.OK);
    }

    //metodos 2 , 2 campos visibles
    @GetMapping("/buscar2/nombredesc")
    public ResponseEntity<List<ProductDTO>> buscarNombreDesc2(@RequestParam("name") String name , @RequestParam ("desc") String desc ) throws Exception {
        List<ProductDTO> buscar2 = mapperUtil.mapList(service.getNameAndDescription2(name,desc),ProductDTO.class);
        return new ResponseEntity<>(buscar2,HttpStatus.OK);

    }




}
