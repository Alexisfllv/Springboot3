package com.edu.service.impl;

import com.edu.model.Provider;

import com.edu.repository.IGenericJPARepo;
import com.edu.repository.IProviderRepo;
import com.edu.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl extends CRUDImpl<Provider,Integer> implements IProviderService {


    //ioc
    private final IProviderRepo repo;

    @Override
    protected IGenericJPARepo<Provider, Integer> getRepo() {
        return repo;
    }
}
