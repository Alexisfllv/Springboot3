package com.edu.controller;

import com.edu.dto.SaleDTO;
import com.edu.dto.prod.IProcedureSale2DTO;
import com.edu.dto.prod.ProcedureSale1DTO;
import com.edu.model.Sale;
import com.edu.service.impl.SaleServiceImpl;
import com.edu.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    //
    private final SaleServiceImpl service;

    private final MapperUtil mapperUtil;

    //metodos
    @PostMapping
    public ResponseEntity<SaleDTO> registrar(@Valid @RequestBody SaleDTO dto) throws Exception {
        Sale registro = service.save(mapperUtil.map(dto, Sale.class));
        return new ResponseEntity<>(mapperUtil.map(registro,SaleDTO.class), HttpStatus.CREATED);
    }

    //listar
    @GetMapping("/listar")
    public ResponseEntity<List<SaleDTO>> listartodo() throws Exception {
        List<SaleDTO> listado = mapperUtil.mapList(service.findAll(),SaleDTO.class);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    //buscarxid
    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> buscarid(@Valid @PathVariable ("id") Integer id) throws Exception {
        Sale listar = service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(listar,SaleDTO.class), HttpStatus.OK);
    }

    //modificar
    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> modificar(@Valid @RequestBody SaleDTO dto, @PathVariable ("id") Integer id) throws Exception {
        Sale registro = service.update(id, mapperUtil.map(dto, Sale.class));
        return new ResponseEntity<>(mapperUtil.map(registro,SaleDTO.class), HttpStatus.OK);
    }

    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //
    //metodo prods
    @GetMapping("/resumen1")
    public ResponseEntity<List<ProcedureSale1DTO>> listado(){
        List<ProcedureSale1DTO> listado = service.listadoCantidadFecha();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    //
    @GetMapping("/resumen10")
    public ResponseEntity<List<?>> listado10(){
        return ResponseEntity.ok(service.listadoCantidadFecha());
    }

    //interfaz proyectada2
    //metodo prods
    @GetMapping("/resumen2")
    public ResponseEntity<List<IProcedureSale2DTO>> listado2(){
        List<IProcedureSale2DTO> listado = service.listadoCantidadFecha2();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }
    //3
    @GetMapping("/resumen3")
    public ResponseEntity<List<ProcedureSale1DTO>> listado3(){
        List<ProcedureSale1DTO> listado = service.listadoCantidadFecha3();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    //4
    @GetMapping("/resumen4")
    public ResponseEntity<Void> listado4(){
        service.callprocedure4();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
