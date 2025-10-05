package com.bzdata.GestionCinema.rolefunctionality;

import com.bzdata.GestionCinema.Funtionality.Functionality;
import com.bzdata.GestionCinema.Funtionality.FunctionalityRepository;
import com.bzdata.GestionCinema.role.Role;
import com.bzdata.GestionCinema.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleFunctionalityServiceImpl implements RoleFunctionalityService {

    private final RoleFunctionalityRepository repository;
    private final RoleRepository roleRepository;
    private final FunctionalityRepository functionalityRepository;
    private final RoleFunctionalityMapper mapper;

    @Override
    public RoleFunctionalityDTO create(RoleFunctionalityDTO dto) {
        Role role = roleRepository.findById(dto.getRoleId().intValue())
                .orElseThrow(() -> new RuntimeException("Role non trouvé"));
        Functionality functionality = functionalityRepository.findById(dto.getFunctionalityId().intValue())
                .orElseThrow(() -> new RuntimeException("Fonctionnalité non trouvée"));

        RoleFunctionality entity = mapper.toEntity(dto, role, functionality);
        RoleFunctionality saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public RoleFunctionalityDTO update(Integer id, RoleFunctionalityDTO dto) {
        RoleFunctionality entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoleFunctionality non trouvé"));

        Role role = roleRepository.findById(dto.getRoleId().intValue())
                .orElseThrow(() -> new RuntimeException("Role non trouvé"));
        Functionality functionality = functionalityRepository.findById(dto.getFunctionalityId().intValue())
                .orElseThrow(() -> new RuntimeException("Fonctionnalité non trouvée"));

        entity.setRole(role);
        entity.setFunctionality(functionality);
        entity.setLecture(dto.isLecture());
        entity.setWriting(dto.isWriting());
        entity.setModification(dto.isModification());
        entity.setDeletion(dto.isDeletion());
        entity.setImpression(dto.isImpression());
        entity.setValidation(dto.isValidation());

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<RoleFunctionalityDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleFunctionalityDTO getById(Integer id) {
        RoleFunctionality entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoleFunctionality non trouvé"));
        return mapper.toDTO(entity);
    }

    @Override
    public List<RoleFunctionalityDTO> getByRoleId(Integer roleId) {
        return repository.findByRole_Id(roleId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
