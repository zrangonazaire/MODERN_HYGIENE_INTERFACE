package com.bzdata.GestionCinema.gestionSocieteEntrepriseService;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@JsonInclude(NON_DEFAULT)
public class DepartmentResponseDto {
    private Long id;
    private String code;
    private String nom;
    private int idEtablissement;
    private String codeEtablissement;
    private String libelleEtablissement;
}
