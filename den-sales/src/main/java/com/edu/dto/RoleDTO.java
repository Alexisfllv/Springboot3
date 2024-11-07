package com.edu.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    @NotNull
    private Integer idRole;

    @NotNull
    private String nameRole;

    @NotNull
    private boolean enabledRole;
}
