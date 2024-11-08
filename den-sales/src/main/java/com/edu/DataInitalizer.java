package com.edu;

import com.edu.dto.*;
import com.edu.model.*;
import com.edu.service.impl.*;
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
    private final ClientServiceImpl clientService;
    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;
    private final ProviderServiceImpl providerService;
    private final SaleServiceImpl saleService;

    private final ModelMapper defaultModelMapper;

    @Override
    public void run(String... args) throws Exception {
        cargarCategoryJson();
        cargarProductJson();
        cargarClientJson();
        cargarRoleJson();
        cargarUserJson();
        cargarProviderJson();
        cargarSaleJson();

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
    private void cargarClientJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/client.json")) {
            // Lee el JSON y convierte a una lista de ProductDTO
            List<ClientDTO> clientDTOS = objectMapper.readValue(inputStream, new TypeReference<List<ClientDTO>>() {});

            for (ClientDTO clientDTO : clientDTOS) {
                // Mapea ProductDTO a la entidad Product
                Client client = defaultModelMapper.map(clientDTO, Client.class);
                // Guarda la entidad Product
                clientService.save(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarRoleJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/role.json")) {
            // Lee el JSON y convierte a una lista de ProductDTO
            List<RoleDTO> roleDTOS = objectMapper.readValue(inputStream, new TypeReference<List<RoleDTO>>() {});

            for (RoleDTO roleDTO : roleDTOS) {
                // Mapea ProductDTO a la entidad Product
                Role role = defaultModelMapper.map(roleDTO, Role.class);
                // Guarda la entidad Product
                roleService.save(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarUserJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/user.json")) {
            // Lee el JSON y convierte a una lista de ProductDTO
            List<UserDTO> userDTOS = objectMapper.readValue(inputStream, new TypeReference<List<UserDTO>>() {});

            for (UserDTO userDTO : userDTOS) {
                // Mapea ProductDTO a la entidad Product
                User user = defaultModelMapper.map(userDTO, User.class);
                // Guarda la entidad Product
                userService.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarProviderJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/provider.json")) {
            // Lee el JSON y convierte a una lista de ProductDTO
            List<ProviderDTO> providerDTOS = objectMapper.readValue(inputStream, new TypeReference<List<ProviderDTO>>() {});

            for (ProviderDTO providerDTO : providerDTOS) {
                // Mapea ProductDTO a la entidad Product
                Provider provider = defaultModelMapper.map(providerDTO, Provider.class);
                // Guarda la entidad Product
                providerService.save(provider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarSaleJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/sale.json")) {
            // Lee el JSON y convierte a una lista de ProductDTO
            List<SaleDTO> saleDTOS = objectMapper.readValue(inputStream, new TypeReference<List<SaleDTO>>() {});

            for (SaleDTO saleDTO : saleDTOS) {
                // Mapea ProductDTO a la entidad Product
                Sale sale = defaultModelMapper.map(saleDTO, Sale.class);
                // Guarda la entidad Product
                saleService.save(sale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //

}
