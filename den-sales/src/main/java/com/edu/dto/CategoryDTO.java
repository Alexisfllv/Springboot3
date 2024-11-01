package com.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer idCategory;
    private String nameCategory;
    private String descriptionCategory;
    private boolean enabledCategory;
    private String codeCategory;
}
