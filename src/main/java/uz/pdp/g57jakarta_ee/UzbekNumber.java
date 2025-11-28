package uz.pdp.g57jakarta_ee;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {UzbekNumberValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface UzbekNumber {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
