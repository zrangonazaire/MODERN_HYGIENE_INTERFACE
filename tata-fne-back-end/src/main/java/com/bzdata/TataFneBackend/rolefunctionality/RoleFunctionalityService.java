package com.bzdata.TataFneBackend.rolefunctionality;

import java.util.List;

public interface RoleFunctionalityService {
    RoleFunctionalityDTO create(RoleFunctionalityDTO dto);
    RoleFunctionalityDTO update(Integer id, RoleFunctionalityDTO dto);
    void delete(Integer id);
    List<RoleFunctionalityDTO> getAll();
    RoleFunctionalityDTO getById(Integer id);
    List<RoleFunctionalityDTO> getByRoleId(Integer roleId);
}
