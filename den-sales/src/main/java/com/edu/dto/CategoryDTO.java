package com.edu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {


    private Integer idCategory;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50 )
    private String nameofCategory;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    private String descriptionCategory;


    private boolean enabledCategory;

}
