package com.edu.deenintegracion.repo;

import com.edu.deenintegracion.model.Category;
import com.edu.deenintegracion.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
