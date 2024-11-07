package com.edu.controller;

import com.edu.dto.ClientDTO;
import com.edu.model.Client;
import com.edu.service.impl.ClientServiceImpl;
import com.edu.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    //ioc
    private final ClientServiceImpl service;

    private final MapperUtil mapperUtil;

    //METODOS
    @PostMapping
    public ResponseEntity<ClientDTO> guardarClient(@Valid  @RequestBody ClientDTO dto) throws Exception {
        Client guardar = service.save(mapperUtil.map(dto,Client.class));

        return new ResponseEntity<>(mapperUtil.map(guardar,ClientDTO.class), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClientDTO>> listar() throws Exception {

        List<ClientDTO> listar=  mapperUtil.mapList(service.findAll(),ClientDTO.class);
        return new ResponseEntity<>(listar,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> buscarporId(@Valid @PathVariable("id") Integer id) throws Exception {
        Client buscarId = service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(buscarId,ClientDTO.class),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> modificar(@Valid @PathVariable("id") Integer id ,@RequestBody ClientDTO dto ) throws Exception {
        Client modificar = service.update(id, mapperUtil.map(dto,Client.class));
        return new ResponseEntity<>(mapperUtil.map(modificar,ClientDTO.class),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
