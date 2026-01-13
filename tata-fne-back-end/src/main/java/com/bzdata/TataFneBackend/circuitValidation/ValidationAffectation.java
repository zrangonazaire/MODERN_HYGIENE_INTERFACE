package com.bzdata.TataFneBackend.circuitValidation;

import com.bzdata.TataFneBackend.user.User;

import jakarta.persistence.*;

@Entity
@Table(name = "validation_affectations")
public class ValidationAffectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;         // Ex: ALLA2, ABE2...
    private String service;       // Ex: TME
    private String codeTypePiece; // Ex: DEBOURS DOUANE
    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private NiveauValidation niveau;
}
