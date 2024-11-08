package com.edu.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDTO {

    //
    private Integer idSale;

    @NotNull
    private ClientDTO client;

    @NotNull
    @JsonIncludeProperties(value = "idUser")
    private UserDTO user;


    @NotNull
    private Date dateTime;
    @NotNull
    private double total;
    @NotNull
    private double tax;
    @NotNull
    private boolean enabled;


    //Maestro detalle
    @NotNull
    @JsonManagedReference
    private List<SaleDetailDTO> details;

}
