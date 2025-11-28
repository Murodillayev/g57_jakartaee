package uz.pdp.g57jakarta_ee;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UzbekNumberValidator implements ConstraintValidator<UzbekNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.matches("^(\\+998|8|\\+998[- ]?)?[- ]?(\\d{2})[- ]?(\\d{3})[- ]?(\\d{2})[- ]?(\\d{2})$");
    }
}
