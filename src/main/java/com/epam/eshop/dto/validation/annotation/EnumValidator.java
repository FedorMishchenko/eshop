package com.epam.eshop.dto.validation.annotation;

import com.epam.eshop.dto.validation.EnumValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface EnumValidator {

    String NOT_VALID_VALUE = "Not valid value";

    /**
     * @return enum class
     */
    Class<? extends Enum<?>> enumClazz();

    /**
     * @return String
     */
    String message() default NOT_VALID_VALUE;

    /**
     * @return Class<?>[]
     */
    Class<?>[] groups() default {};

    /**
     * @return Class<?       extends       Payload>[]
     */
    Class<? extends Payload>[] payload() default {};
}
