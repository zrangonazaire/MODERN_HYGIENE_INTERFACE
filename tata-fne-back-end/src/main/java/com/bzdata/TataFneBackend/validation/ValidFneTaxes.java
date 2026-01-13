package com.bzdata.TataFneBackend.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidFneTaxesValidator.class)
public @interface ValidFneTaxes {
    String message() default "taxes must contain exactly one of: TVA, TVAB, TVAC, TVAD, TVAE";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
