package com.edu.service;

import com.edu.model.Category;
import com.edu.repository.ICategoryRepo;
import com.edu.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @MockBean
    private ICategoryRepo repo;

    @MockBean
    private ICategoryService service;

    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    public void init(){
        //inicializar mocks
        MockitoAnnotations.openMocks(this);
        this.service = new CategoryServiceImpl(repo);

        //Datos fisicos
        category1  = new Category(1, "TV", "Television", true);
        category2  = new Category(2, "TV", "Television", true);
        category3  = new Category(3, "TV", "Television", true);

        //simulacion
        List<Category> categories = List.of(category1, category2, category3);
        Mockito.when(repo.findAll()).thenReturn(categories);
        Mockito.when(repo.findById(any())).thenReturn(Optional.of(category1));
        Mockito.when(repo.save(any())).thenReturn(category1);

    }

    @Test
    void reallTest()throws Exception{
        List<Category> response = service.findAll();

        //assertNotNull(response);
        //assertTrue(response.isEmpty());
        assertEquals(response.size(),3);
    }

    @Test
    void readByIdTest()throws Exception{
        final int ID = 1;
        Category response = service.findById(ID);

        assertNotNull(response);
    }

    @Test
    void saveTest()throws Exception{
        Category response = service.save(category1);

        assertNotNull(response);
    }

    @Test
    void updateTest()throws Exception{
        Category response = service.update(1,category1);
        assertNotNull(response);
    }

    @Test
    void deleteTest()throws Exception{
        final int ID =1;
        service.delete(ID);

        //repuesta void
        verify(repo,times(1)).deleteById(ID);
    }
}
