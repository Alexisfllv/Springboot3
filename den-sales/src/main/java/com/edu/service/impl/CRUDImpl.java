package com.edu.service.impl;

import com.edu.repository.IGenericJPARepo;
import com.edu.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    //traer el obj repo
    protected abstract IGenericJPARepo<T,ID> getRepo();


    @Override
    public boolean ByidifExist(ID id) throws Exception {
        return getRepo().existsById(id);
    }

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        //rec id
        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}