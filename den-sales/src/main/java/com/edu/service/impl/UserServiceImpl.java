package com.edu.service.impl;

import com.edu.model.User;
import com.edu.repository.IGenericJPARepo;
import com.edu.repository.IUserRepo;
import com.edu.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User,Integer> implements IUserService {

    //ioc repo
    private final IUserRepo repo;

    @Override
    protected IGenericJPARepo<User, Integer> getRepo() {
        return repo;
    }
}
