package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;
import java.util.List;

public interface SocieteService {
    SocieteResponseDTO create(SocieteRequestDTO societe);
    SocieteResponseDTO update(int id, SocieteRequestDTO societe);
    void delete(int id);
    SocieteResponseDTO findById(int id);
    List<SocieteResponseDTO> findAll();
}
