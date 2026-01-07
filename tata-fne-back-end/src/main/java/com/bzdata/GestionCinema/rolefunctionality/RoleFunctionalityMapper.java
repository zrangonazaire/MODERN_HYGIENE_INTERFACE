package com.bzdata.GestionCinema.rolefunctionality;

import com.bzdata.GestionCinema.Funtionality.Functionality;
import com.bzdata.GestionCinema.role.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleFunctionalityMapper {

    public RoleFunctionality toEntity(RoleFunctionalityDTO dto, Role role, Functionality functionality) {
        if (dto == null || role == null || functionality == null) return null;

        RoleFunctionality entity = new RoleFunctionality();
        entity.setRole(role);
        entity.setFunctionality(functionality);
        entity.setLecture(dto.isLecture());
        entity.setWriting(dto.isWriting());
        entity.setModification(dto.isModification());
        entity.setDeletion(dto.isDeletion());
        entity.setImpression(dto.isImpression());
        entity.setValidation(dto.isValidation());
        entity.setDateAffected(java.time.LocalDate.now());
        return entity;
    }

    public RoleFunctionalityDTO toDTO(RoleFunctionality entity) {
        if (entity == null) return null;

        RoleFunctionalityDTO dto = new RoleFunctionalityDTO();
        dto.setRoleId((long) entity.getRole().getId());
        dto.setFunctionalityId((long) entity.getFunctionality().getIdFunctionality());
        dto.setLecture(entity.isLecture());
        dto.setWriting(entity.isWriting());
        dto.setModification(entity.isModification());
        dto.setDeletion(entity.isDeletion());
        dto.setImpression(entity.isImpression());
        dto.setValidation(entity.isValidation());
        return dto;
    }
}
