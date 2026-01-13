package com.bzdata.TataFneBackend.gestionSocieteEntrepriseService;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

import com.bzdata.TataFneBackend.user.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String codeEtablissement;
    @Column(nullable = false)
    private String nom;
    private String typeEtablissement; // Siège, Agence, Atelier, etc.
    private String adresse;
    private String ville;
    private String telephone;
    private String email;
    private String responsable;
    private String dateOuverture;
    private String activitePrincipale;
    private Integer effectif;
    // 🔗 Lien vers la société mère
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societe_id")
    private Societe societe;
    // 🔗 Lien ManyToMany vers les utilisateurs
    @ManyToMany(mappedBy = "etablissements", fetch = FetchType.LAZY)
    private Set<User> utilisateurs;
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
