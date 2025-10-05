package com.bzdata.GestionCinema.attributionDroit;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AttributionDTO {


    @NotNull(message = "userId requis")
    private int userId;

    @NotNull(message = "functionalityId requis")
    private int functionalityId;

    private boolean lecture;
    private boolean writing;
    private boolean modification;
    private boolean deletion;
    private boolean impression;
    private boolean validation;
}