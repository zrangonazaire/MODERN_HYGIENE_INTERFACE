package com.bzdata.TataFneBackend.rolefunctionality;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleFunctionalityRepository extends JpaRepository<RoleFunctionality, Integer> {
    List<RoleFunctionality> findByRole_Id(Integer id);
    List<RoleFunctionality> findByFunctionality_IdFunctionality(Integer id);
    Optional<RoleFunctionality> findByRole_IdAndFunctionality_IdFunctionality(Integer roleId, Integer functionalityId);
}