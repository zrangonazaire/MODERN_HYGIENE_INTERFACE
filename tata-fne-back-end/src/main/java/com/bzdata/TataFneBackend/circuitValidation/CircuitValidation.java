package com.bzdata.TataFneBackend.circuitValidation;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.bzdata.TataFneBackend.gestionSocieteEntrepriseService.Department;
import com.bzdata.TataFneBackend.gestionSocieteEntrepriseService.Etablissement;

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
