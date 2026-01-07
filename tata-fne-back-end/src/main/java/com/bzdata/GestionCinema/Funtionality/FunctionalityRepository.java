package com.bzdata.GestionCinema.Funtionality;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FunctionalityRepository extends JpaRepository<Functionality, Integer> {

    Optional<Functionality> findByCodeFunctionality(String codeFunctionality);
}
