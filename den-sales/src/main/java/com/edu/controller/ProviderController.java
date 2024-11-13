package com.edu.controller;


import com.edu.dto.ProviderDTO;
import com.edu.model.Provider;
import com.edu.service.impl.ProviderServiceImpl;
import com.edu.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/providers")
public class ProviderController {

    //ioc
    private final ProviderServiceImpl service;

    private final MapperUtil mapperUtil;

    //metodos

    //listar
    @GetMapping("/listar")
    public ResponseEntity<List<ProviderDTO>> listarTodos() throws Exception {
        List<ProviderDTO> listado = mapperUtil.mapList(service.findAll(), ProviderDTO.class);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    //listar x id

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> buscarPorId(@PathVariable("id") Integer id) throws Exception {
        Provider buscarxid =service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(buscarxid, ProviderDTO.class), HttpStatus.OK);
    }

    //registrar

    @PostMapping
    public ResponseEntity<ProviderDTO> inserir(@Valid  @RequestBody ProviderDTO dto) throws Exception {
        Provider reg = service.save(mapperUtil.map(dto, Provider.class));

        return new ResponseEntity<>(mapperUtil.map(reg, ProviderDTO.class), HttpStatus.CREATED);
    }

    //modfiicar
    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> atualizar(@Valid @PathVariable("id") Integer id, @RequestBody ProviderDTO dto) throws Exception {
        //enviar el id al body json
        //dto.setIdProvider(id);
        Provider act = service.update(id, mapperUtil.map(dto, Provider.class));
        return new ResponseEntity<>(mapperUtil.map(act, ProviderDTO.class), HttpStatus.OK);
    }

    //eliminar

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
