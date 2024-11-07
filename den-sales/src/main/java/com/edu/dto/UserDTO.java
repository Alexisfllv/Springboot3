package com.edu.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private Integer idUser;

    @NotNull
    private Integer idRole;

    @NotNull
    private String usernameUser;

    @NotNull
    private String passwordUser;

    @NotNull
    private boolean enabledUser;
}
