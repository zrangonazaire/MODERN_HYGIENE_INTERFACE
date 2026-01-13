package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;

import java.util.List;

import com.bzdata.TataFneBackend.user.User;


public interface DepartmentService {
    DepartmentResponseDto create(DepartmentRequestDto service);
    DepartmentResponseDto addUsers(Long serviceId, List<Integer> utilisateurIds);
    DepartmentResponseDto removeUser(Long serviceId, int utilisateurId);
    List<DepartmentResponseDto> getServicesByEtablissement(int etablissementId);
    List<User> getUtilisateursByService(Long serviceId);
    DepartmentResponseDto updateService(Long id, String nom, String code);
    void deleteService(Long id);
}
