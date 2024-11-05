package com.edu.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {

    private Integer idProduct;

    @NotNull
    @Min(value = 1)
    private Integer idCategory;

    @NotNull
    private String nameProduct;

    @NotNull
    private double priceProduct;

    @NotNull
    private String descriptionProduct;

    @NotNull
    private boolean enabledProduct;


}
