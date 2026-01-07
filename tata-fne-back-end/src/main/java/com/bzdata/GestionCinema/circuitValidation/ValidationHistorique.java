package com.bzdata.GestionCinema.circuitValidation;

import com.bzdata.GestionCinema.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "validation_historique")
public class ValidationHistorique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User validedPar;     // Ex: ALLA2
    @ManyToOne(fetch = FetchType.LAZY)
    private NiveauValidation niveauValidation;      // Ex: DOP, CHEFAG
    private LocalDateTime dateValidation;
}

