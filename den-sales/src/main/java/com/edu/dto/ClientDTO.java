package com.edu.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

    private Integer idClient;

    @NotNull
    private String firstNameClient;
    @NotNull
    private String lastNameClient;

    @NotNull
    private String cardIdClient;

    @NotNull
    @Email
    private String emailClient;

    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String phoneNumberClient;

    @NotNull
    private String addressClient;

    @NotNull
    private String countryClient;
}
