package com.edu.controller;

import com.edu.dto.UserDTO;
import com.edu.model.User;
import com.edu.service.impl.UserServiceImpl;
import com.edu.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //
    private final UserServiceImpl service;

    private final MapperUtil mapperUtil;

    //metodos
    @PostMapping
    public ResponseEntity<UserDTO> registrar(@Valid @RequestBody UserDTO dto) throws Exception {
        User registro = service.save(mapperUtil.map(dto, User.class));
        return new ResponseEntity<>(mapperUtil.map(registro,UserDTO.class), HttpStatus.CREATED);
    }

    //listar
    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> listartodo() throws Exception {
        List<UserDTO> listado = mapperUtil.mapList(service.findAll(),UserDTO.class);
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    //buscarxid
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> buscarid(@Valid @PathVariable ("id") Integer id) throws Exception {
        User listar = service.findById(id);
        return new ResponseEntity<>(mapperUtil.map(listar,UserDTO.class), HttpStatus.OK);
    }

    //modificar
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> modificar(@Valid @RequestBody UserDTO dto, @PathVariable ("id") Integer id) throws Exception {
        User registro = service.update(id, mapperUtil.map(dto, User.class));
        return new ResponseEntity<>(mapperUtil.map(registro,UserDTO.class), HttpStatus.OK);
    }

    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
