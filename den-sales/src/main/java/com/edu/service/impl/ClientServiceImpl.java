package com.edu.service.impl;

import com.edu.model.Client;
import com.edu.repository.IGenericJPARepo;
import com.edu.repository.IClientRepo;
import com.edu.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Client,Integer> implements IClientService {

    //ioc
    private final IClientRepo repo;


    @Override
    protected IGenericJPARepo<Client, Integer> getRepo() {
        return repo;
    }
}
