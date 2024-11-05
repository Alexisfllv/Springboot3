package com.edu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {


    private Integer idCategory;

    @NotNull
    @NotEmpty
    @NotBlank(message = "no enviar espacios")
    @Size(min = 2, max = 50 , message = "minimo 2")
    private String nameCategory;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    private String descriptionCategory;


    private boolean enabledCategory;
    private String codeCategory;

}
