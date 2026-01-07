package com.bzdata.GestionCinema.circuitValidation;

import com.bzdata.GestionCinema.gestionSocieteEntrepriseService.Etablissement;
import com.bzdata.GestionCinema.gestionSocieteEntrepriseService.Department;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CircuitValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCircuit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablissement_id")
    private Etablissement etablissement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Department department;

    @OneToOne(mappedBy = "circuit", cascade = CascadeType.ALL, orphanRemoval = true)
    private NiveauValidation niveauValidation;
}
