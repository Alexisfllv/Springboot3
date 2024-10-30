package com.edu.service;



import java.util.List;

public interface ICRUD<T,ID> {

    //metodos

    //metodo de creacion
    T save(T t) throws Exception;

    //metodos de lectura
    List<T> findAll()throws Exception;
    T findById(ID id)throws Exception;

    //metodos de actualizacion
    T update(ID id ,T t )throws Exception;

    //metodos de eliminacion
    void delete(ID id)throws Exception;

    //verificar
    boolean ByidifExist(ID id)throws Exception;
}
