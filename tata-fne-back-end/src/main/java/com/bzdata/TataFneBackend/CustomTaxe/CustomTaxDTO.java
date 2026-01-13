package com.bzdata.TataFneBackend.CustomTaxe;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record CustomTaxDTO(
        @NotBlank(message = "custom tax name is required")
        String name,
        @PositiveOrZero(message = "custom tax amount must be >= 0")
        double amount
) {}
