package com.edu.controller;


import com.edu.service.ICategoryService;
import com.edu.util.MapperUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    //
    @Autowired
    private MockMvc mockMvc;

    //beans
    @MockBean
    private ICategoryService service;

    @MockBean
    private MapperUtil mapperUtil;


    //listar todas las categorias
    @Test
    void readAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/categories")
                .content(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(3)));
    }
}
