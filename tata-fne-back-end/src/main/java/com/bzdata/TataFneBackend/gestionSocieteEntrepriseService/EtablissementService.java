package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;

import java.util.List;

public interface EtablissementService {
    EtablissementResponseDTO create(EtablissementRequestDTO etablissement);
    EtablissementResponseDTO update(int id,EtablissementRequestDTO etablissement);
    EtablissementResponseDTO getById(int id);
    List<EtablissementResponseDTO> getAll();
    List<EtablissementResponseDTO> getAllEtablissementByIdSociete(int IdSociete);
    void delete(int id);
}