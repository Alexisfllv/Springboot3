package com.edu.controller;

import com.edu.dto.RoleDTO;
import com.edu.dto.UserDTO;
import com.edu.model.Role;
import com.edu.model.User;
import com.edu.service.impl.RoleServiceImpl;
import com.edu.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rols")
public class RoleController {

    //ioc
    private  final RoleServiceImpl service;

    private final MapperUtil mapperUtil;

    //metodos

    @GetMapping("/listar")
    public ResponseEntity<List<RoleDTO>> listarTodos() throws Exception {
        List<RoleDTO> listar = mapperUtil.mapList(service.findAll(),RoleDTO.class);
        return new ResponseEntity<>(listar, HttpStatus.OK);
    }

    //
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> buscarxid(@PathVariable("id") Integer id) throws Exception {
        Role buscar = service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(buscar,RoleDTO.class),HttpStatus.OK);
    }

    //
    @PostMapping
    public ResponseEntity<RoleDTO> insertar(@Valid  @RequestBody RoleDTO dto) throws Exception {
        Role insertar = mapperUtil.map(dto,Role.class);
        return new ResponseEntity<>(mapperUtil.map(service.save(insertar),RoleDTO.class),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> modificar(@Valid @RequestBody RoleDTO dto, @PathVariable("id") Integer id) throws Exception {
        Role modificar = service.update(id, mapperUtil.map(dto,Role.class));
        return new ResponseEntity<>(mapperUtil.map(modificar,RoleDTO.class),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
