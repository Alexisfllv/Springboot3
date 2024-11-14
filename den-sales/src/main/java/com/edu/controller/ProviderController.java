package com.edu.controller;


import com.edu.dto.ProviderDTO;
import com.edu.dto.Response.GenericResponse;
import com.edu.model.Provider;
import com.edu.service.impl.ProviderServiceImpl;
import com.edu.util.MapperUtil;
import com.mysql.cj.x.protobuf.Mysqlx;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/providers")
public class ProviderController {

    //ioc
    private final ProviderServiceImpl service;

    private final MapperUtil mapperUtil;

    //metodos

    //        return new ResponseEntity<>(new GenericResponse<>(200,"succes",listado));
    //        return new ResponseEntity<>(new GenericResponse<>(200, "success", listado), HttpStatus.OK);
    //listar
    @GetMapping("/listar")
    public ResponseEntity<GenericResponse<ProviderDTO>> listarTodos() throws Exception {
        List<ProviderDTO> listado = mapperUtil.mapList(service.findAll(), ProviderDTO.class);
        return new ResponseEntity<>(new GenericResponse<>(200,"success",listado),HttpStatus.OK);
        //return ResponseEntity.ok(new GenericResponse<>(200,"succes",listado));
        //return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    //listar x id

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ProviderDTO>> buscarPorId(@PathVariable("id") Integer id) throws Exception {
        ProviderDTO  buscarxid = mapperUtil.map(service.findById(id), ProviderDTO.class);
        return new ResponseEntity<>(new GenericResponse<>(200,"success", Arrays.asList(buscarxid)),HttpStatus.OK);
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
