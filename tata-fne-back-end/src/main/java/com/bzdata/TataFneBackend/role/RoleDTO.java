package com.bzdata.TataFneBackend.role;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDTO {


    @NotBlank(message = "Le code du rôle est obligatoire")
    private String code;

    @NotBlank(message = "Le nom du rôle est obligatoire")
    private String nom;
}