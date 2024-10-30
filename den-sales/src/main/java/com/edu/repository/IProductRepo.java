package com.edu.repository;

import com.edu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends IGenericJPARepo<Product, Integer> {
}
