package com.edu.service;

import com.edu.model.Client;

import java.util.List;

public interface IClientService {

    //metodos

    //metodo de creacion
    Client save(Client client) throws Exception;

    //metodos de lectura
    List<Client> findAll()throws Exception;
    Client findById(Integer id)throws Exception;

    //metodos de actualizacion
    Client update(Integer id ,Client client )throws Exception;

    //metodos de eliminacion
    void delete(Integer id)throws Exception;

    //verificar
    boolean ByidifExist(Integer id)throws Exception;
}
