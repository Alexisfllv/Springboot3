package com.edu;

import com.edu.dto.ProductDTO;
import com.edu.model.Category;
import com.edu.model.Product;
import com.edu.service.impl.CategoryServiceImpl;
import com.edu.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitalizer implements CommandLineRunner {


    private final CategoryServiceImpl categoryService;
    private final ProductServiceImpl productService;
    private final ModelMapper defaultModelMapper;

    @Override
    public void run(String... args) throws Exception {
        cargarCategoryJson();
        cargarProductJson();

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

    private void cargarProductJsons() {
        ObjectMapper objectMapper = new ObjectMapper();
        try(InputStream inputStream = getClass().getResourceAsStream("/product.json")){
            List<Product> products = objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});

            for (Product product : products) {
                productService.save(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void cargarProductJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/product.json")) {
            // Lee el JSON y convierte a una lista de ProductDTO
            List<ProductDTO> productDTOs = objectMapper.readValue(inputStream, new TypeReference<List<ProductDTO>>() {});

            for (ProductDTO productDTO : productDTOs) {
                // Mapea ProductDTO a la entidad Product
                Product product = defaultModelMapper.map(productDTO, Product.class);
                // Guarda la entidad Product
                productService.save(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
