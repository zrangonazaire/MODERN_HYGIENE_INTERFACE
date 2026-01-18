package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.bzdata.TataFneBackend.user.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String nom;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToMany
    @JoinTable(name = "service_utilisateur",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private List<User> utilisateurs;
}