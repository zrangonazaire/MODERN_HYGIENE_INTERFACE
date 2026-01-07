package com.bzdata.GestionCinema.gestionSocieteEntrepriseService;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@JsonInclude(NON_DEFAULT)
public class EtablissementRequestDTO {
    private String codeEtablissement;
    private String nom;
    private String typeEtablissement;
    private String adresse;
    private String ville;
    private String telephone;
    private String email;
    private String responsable;
    private String dateOuverture;
    private String activitePrincipale;
    @NotNull(message = "L'id de la société est obligatoire")
    @Min(value = 1, message = "L'id de la société doit être supérieur à 0")
    private int idSociete;
}