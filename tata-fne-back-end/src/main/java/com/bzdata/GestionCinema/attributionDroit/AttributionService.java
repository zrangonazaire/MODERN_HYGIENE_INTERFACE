package com.bzdata.GestionCinema.attributionDroit;

import java.util.List;

public interface AttributionService {
    AttributionDTO create(AttributionDTO dto);
    AttributionDTO update(Long id, AttributionDTO dto);
    void delete(Long id);
    List<AttributionDTO> getAll();
    AttributionDTO getById(Long id);
    List<AttributionDTO> getByUserId(int userId);
    // Nouvelle méthode pour lister les fonctionnalités par role
    List<AttributionDTO> getFunctionalitiesByRoleId(int roleId);
}
