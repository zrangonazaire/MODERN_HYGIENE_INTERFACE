package com.bzdata.TataFneBackend.validation;

import java.util.List;
import java.util.Set;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidFneTaxesValidator implements ConstraintValidator<ValidFneTaxes, List<String>> {
    private static final Set<String> ALLOWED = Set.of("TVA", "TVAB", "TVAC", "TVAD", "TVAE");

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if (value == null || value.size() != 1) {
            return false;
        }
        String tax = value.get(0);
        if (tax == null) {
            return false;
        }
        return ALLOWED.contains(tax.trim().toUpperCase());
    }
}
