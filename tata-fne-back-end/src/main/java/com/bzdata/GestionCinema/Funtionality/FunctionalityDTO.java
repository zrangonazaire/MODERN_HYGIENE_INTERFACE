package com.bzdata.GestionCinema.Funtionality;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FunctionalityDTO {

    @NotBlank(message = "Le code est obligatoire")
    private String code;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    private String description;
}
