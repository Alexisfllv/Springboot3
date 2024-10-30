package com.edu.repository;

import com.edu.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends IGenericJPARepo<Category,Integer> {
}
