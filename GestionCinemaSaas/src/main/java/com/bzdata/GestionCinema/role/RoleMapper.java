package com.bzdata.GestionCinema.role;

import org.springframework.stereotype.Service;

@Service
public class RoleMapper {

    public RoleDTO mapToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode(role.getCode());
        roleDTO.setNom(role.getName());
        return roleDTO;
    }
}
