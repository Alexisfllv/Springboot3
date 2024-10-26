package com.edu;

import com.edu.model.Category;
import com.edu.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.InputStream;
import java.util.List;

@Component
//@RequiredArgsConstructor
public class DataInitalizer implements CommandLineRunner {

    @Autowired
    private  CategoryServiceImpl categoryService;

    @Override
    public void run(String... args) throws Exception {
        cargarCategoryJson();
    }

    private void cargarCategoryJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/category.json")) {
            List<Category> categories = objectMapper.readValue(inputStream, new TypeReference<List<Category>>() {});
            for (Category category : categories) {
                categoryService.save(category); // Guarda cada categoría en la base de datos
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones: imprime el error si ocurre
        }
    }
}
