package com.edu.service.impl;


import com.edu.model.Role;
import com.edu.repository.IGenericJPARepo;
import com.edu.repository.IRoleRepo;
import com.edu.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CRUDImpl<Role,Integer> implements IRoleService {

    //ioc
    private final IRoleRepo repo;


    @Override
    protected IGenericJPARepo getRepo() {
        return repo;
    }
}
