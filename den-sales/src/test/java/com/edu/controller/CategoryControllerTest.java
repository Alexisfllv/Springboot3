package com.edu.controller;


import com.edu.dto.CategoryDTO;
import com.edu.exception.ModelNotFoundException;
import com.edu.model.Category;
import com.edu.service.ICategoryService;
import com.edu.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.any;


@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
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


    //transformar de java a json
    @Autowired
    private ObjectMapper objectMapper;

    //Datos fisicos
    Category cat1 = new Category(1, "TV", "Television", true);
    Category cat2 = new Category(2, "TV", "Television", true);
    Category cat3 = new Category(3, "TV", "Television", true);
    //dto
    CategoryDTO cat1dto = new CategoryDTO(1, "TV", "Television", true);
    CategoryDTO cat2dto = new CategoryDTO(2, "TV", "Television", true);
    CategoryDTO cat3dto = new CategoryDTO(3, "TV", "Television", true);


    //listar todas las categorias
    @Test
    void readAllTest() throws Exception {
        //datos
        List<Category> categories = Arrays.asList(cat1, cat2, cat3);
        Mockito.when(service.findAll())
                .thenReturn(categories);

        Mockito.when(mapperUtil.mapList(categories, CategoryDTO.class, "categoryMapper"))
                .thenReturn(Arrays.asList(cat1dto, cat2dto, cat3dto));


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/categories")
                        .content(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(3)));
    }

    //busqueda con generic reponse
    @Test
    void readByIdTest() throws Exception {
        final int id = 1;

        //proceso de lectura
        Mockito.when(service.findById(id)).thenReturn(cat1);
        Mockito.when(mapperUtil.map(cat1, CategoryDTO.class, "categoryMapper"))
                .thenReturn(cat1dto);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/categories/gec/" + id)
                        .content(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].nameofCategory", is("TV")));
    }

    //busqueda sin generic response

    @Test
    void readByIdTest2() throws Exception {
        final int id = 1;

        // Mock de datos
        Mockito.when(service.findById(id)).thenReturn(cat1);
        Mockito.when(mapperUtil.map(cat1, CategoryDTO.class, "categoryMapper")).thenReturn(cat1dto);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/categories/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nameofCategory", is("TV"))); // Validación del campo esperado
    }

    //
    @Test
    void createTest() throws Exception {

        //simulacion de transformacion
        Mockito.when(service.save(any())).thenReturn(cat1);
        //Mockito.when(service.save(Mockito.eq(cat1))).thenReturn(cat1);
        Mockito.when(mapperUtil.map(cat1, CategoryDTO.class, "categoryMapper"))
                .thenReturn(cat1dto);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/categories")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(cat1dto))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.enabledCategory", is(true)));
    }

    //
    @Test
    void updateTest() throws Exception {

        //simulacion de transformacion
        Mockito.when(service.update(any(),any())).thenReturn(cat2);
        Mockito.when(mapperUtil.map(cat2, CategoryDTO.class, "categoryMapper"))
                .thenReturn(cat2dto);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/categories/"+2)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(cat3dto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enabledCategory", is(true)));
    }

    @Test
    void updateErrorTest() throws Exception {

        final int ID = 99;

        Mockito.when(service.update(any(),any())).thenThrow(new ModelNotFoundException("ID NOT VALID : " + ID));

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/categories/"+ID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(cat3dto))
                )
                .andExpect(status().isBadRequest())
                //.andExpect(result -> assertInstanceOf(ModelNotFoundException.class, result.getResolvedException()))
                .andExpect(result -> assertTrue(result.getResolvedException()instanceof ModelNotFoundException));

    }

    //eliminar

    @Test
    void deleteTest() throws Exception {
        final int ID = 1;


        mockMvc.perform(MockMvcRequestBuilders
                .delete("/categories/"+ID)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteErrorTest() throws Exception {
        final int ID = 99;

        Mockito.doThrow(new ModelNotFoundException("ID NOT VALID : " + ID)).when(service).delete(ID);


        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/categories/"+ID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException()instanceof ModelNotFoundException));
    }
}