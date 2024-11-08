package com.edu.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotNull
    private Integer idUser;

    @JsonIncludeProperties(value = {"idRole","nameRole"})
    @NotNull
    private RoleDTO role;

    //@JsonProperty(value = "user_name") cambiar el nombrel del atributo al enviar y devolver
    @NotNull
    private String usernameUser;

    //@JsonIgnore  ignora en ambos sentidos
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String passwordUser;

    @NotNull
    private boolean enabledUser;
}
