package com.bzdata.GestionCinema.gestionSocieteEntrepriseService;

import com.bzdata.GestionCinema.user.User;

import java.util.List;


public interface DepartmentService {
    DepartmentResponseDto create(DepartmentRequestDto service);
    DepartmentResponseDto addUsers(Long serviceId, List<Integer> utilisateurIds);
    DepartmentResponseDto removeUser(Long serviceId, int utilisateurId);
    List<DepartmentResponseDto> getServicesByEtablissement(int etablissementId);
    List<User> getUtilisateursByService(Long serviceId);
    DepartmentResponseDto updateService(Long id, String nom, String code);
    void deleteService(Long id);
}
