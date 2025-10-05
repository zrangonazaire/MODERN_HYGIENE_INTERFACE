package com.bzdata.GestionCinema.role;
import com.bzdata.GestionCinema.exception.ResourceNonFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO create(RoleDTO dto) {
        Role role = new Role();
        role.setName(dto.getNom());
        role.setCode(dto.getCode());
        var response=roleRepository.save(role);

        return roleMapper.mapToDTO(response);
    }

    @Override
    public RoleDTO update(int id, RoleDTO dto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNonFoundException("Role not found"));
        role.setName(dto.getNom());
        return roleMapper.mapToDTO(roleRepository.save(role));
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleDTO getById(int id) {
        //TODO WE HAVE TO CHECK IL THIS ROLE HAS NOS RELATIONSHIP BEFORE DELETE IT
        return roleRepository.findById(id)
                .map(roleMapper::mapToDTO)
                .orElseThrow(() -> new ResourceNonFoundException("Role not found"));
    }

    @Override
    public List<RoleDTO> getAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::mapToDTO)
                .collect(Collectors.toList());
    }


}
