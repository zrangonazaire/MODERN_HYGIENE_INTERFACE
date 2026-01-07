package com.bzdata.GestionCinema.gestionSocieteEntrepriseService;

public class DepartmentMapper {
    // Méthode pour convertir un DTO en entité (sans établissement pour le moment)
    public static Department toEntity(DepartmentRequestDto dto, Etablissement etablissement) {
        if (dto == null || etablissement==null ) return null;
        Department service = new Department();
        service.setCode(dto.codeService());
        service.setNom(dto.libelleService());
        service.setEtablissement(etablissement);
        return service;
    }
    public static DepartmentResponseDto toResponse(Department entity) {
        if (entity == null) return null;
        Etablissement etablissement = entity.getEtablissement();
        if (etablissement != null) {
            DepartmentResponseDto dto = new DepartmentResponseDto();
            dto.setId(entity.getId());
            dto.setCodeEtablissement(entity.getEtablissement().getCodeEtablissement());
            dto.setLibelleEtablissement(entity.getEtablissement().getNom());
            dto.setNom(entity.getNom());
            dto.setCode(entity.getCode());
            dto.setIdEtablissement(entity.getEtablissement().getId());
            return dto;
        }
        return null;
    }
}
