package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtablissementRepository extends JpaRepository<Etablissement, Integer> {
    List<Etablissement> findBySocieteId(int societeId);

    @Query("SELECT e FROM Etablissement e JOIN FETCH e.societe")
    List<Etablissement> findAllWithSociete();
}
