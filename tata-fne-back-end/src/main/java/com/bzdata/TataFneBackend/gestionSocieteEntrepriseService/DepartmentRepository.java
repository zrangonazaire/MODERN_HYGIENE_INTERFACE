package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByEtablissementId(int etablissementId);
}
