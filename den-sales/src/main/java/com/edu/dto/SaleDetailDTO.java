package com.edu.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDetailDTO {

    //
    //private Integer idSaleDetail;

    //@NotNull
    @JsonBackReference
    private SaleDTO sale;
    @NotNull
    @JsonIncludeProperties(value = "idProduct")
    private ProductDTO product;
    @NotNull
    private short quantity;
    @NotNull
    private short salePrice;
    @NotNull
    private double discount;
}
