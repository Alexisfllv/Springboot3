package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericJPARepo <T,ID> extends JpaRepository<T, ID> {
}
