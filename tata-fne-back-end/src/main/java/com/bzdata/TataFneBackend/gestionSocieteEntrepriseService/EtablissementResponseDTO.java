package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;

import lombok.Data;

@Data
public class EtablissementResponseDTO {
    private int id;
    private String codeEtablissement;
    private String nom;
    private String typeEtablissement;
    private String ville;
    private String responsable;
    private String telephone;
    private String email;
    private int idsociete;
}
