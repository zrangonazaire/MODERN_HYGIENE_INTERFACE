package com.bzdata.GestionCinema.rolefunctionality;

import com.bzdata.GestionCinema.Funtionality.Functionality;
import com.bzdata.GestionCinema.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class RoleFunctionality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Role role;
    @ManyToOne
    private Functionality functionality;
    private LocalDate dateAffected;
    // droits
    private boolean lecture;
    private boolean writing;
    private boolean modification;
    private boolean deletion;
    private boolean impression;
    private boolean validation;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

}
