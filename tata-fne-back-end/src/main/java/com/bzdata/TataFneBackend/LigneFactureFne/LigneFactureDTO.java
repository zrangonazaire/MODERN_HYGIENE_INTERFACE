package com.bzdata.TataFneBackend.LigneFactureFne;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import com.bzdata.TataFneBackend.CustomTaxe.CustomTaxDTO;
import com.bzdata.TataFneBackend.validation.ValidFneTaxes;

public record LigneFactureDTO(
 // ✅ uniquement sur la ligne
        @NotNull(message = "taxes is required")
        @ValidFneTaxes
        List<String> taxes,
        @Valid
        List<CustomTaxDTO> customTaxes,

        String reference,
        @NotBlank(message = "description is required")
        String description,

        @Positive(message = "quantity must be > 0")
        double quantity,
        @PositiveOrZero(message = "amount must be >= 0")
        double amount,
        @PositiveOrZero(message = "discount must be >= 0")
        double discount,

        String measurementUnit
) {}
