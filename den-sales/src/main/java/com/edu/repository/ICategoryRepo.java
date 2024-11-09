package com.edu.repository;

import com.edu.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepo extends IGenericJPARepo<Category,Integer> {

    //DerivedQueries
    //SELECT * FROM Category c WHERE c.name = '';
    List<Category> findByName(String nombre);
}
