package com.bzdata.TataFneBackend.rolefunctionality;


import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoleFunctionalityDTO {

    @NotNull(message = "roleId requis")
    private Long roleId;

    @NotNull(message = "fonctionnaliteId requis")
    private Long functionalityId;

    private boolean lecture;
    private boolean writing;
    private boolean modification;
    private boolean deletion;
    private boolean impression;
    private boolean validation;

    private LocalDate dateAffected;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
