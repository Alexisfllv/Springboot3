package com.edu.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {


    private Integer idProvider;

    @NotNull
    private String nameProvider;

    @NotNull
    private String addressProvider;

    @NotNull
    private boolean enabledProvider;

}
