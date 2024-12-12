package com.edu.repository;

import com.edu.model.User;

public interface IUserRepo extends IGenericJPARepo<User,Integer>{

    //sacar la informacion apartir del nombre

    //FROM USER u WHERE u.username = :username
    User findByUsername(String username);


    User findOneByUsername(String username);
}
