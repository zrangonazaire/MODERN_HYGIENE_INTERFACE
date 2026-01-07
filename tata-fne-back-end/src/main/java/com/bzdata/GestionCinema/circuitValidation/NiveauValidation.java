package com.bzdata.GestionCinema.circuitValidation;
import com.bzdata.GestionCinema.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NiveauValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ordreValidation;

    private String codeNiveau;

    private boolean sautNiveau;

    private boolean finNiveauValidation;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circuit_id")
    private CircuitValidation circuit;

}