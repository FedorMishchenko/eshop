package com.epam.eshop.dto.validation;

import com.epam.eshop.dto.validation.annotation.EnumValidator;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

    private List<String> values;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        values = new ArrayList<>();
        for (Enum anEnum : constraintAnnotation.enumClazz().getEnumConstants()) {
            values.add(anEnum.name().toUpperCase());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isBlank(value) || values.contains(value);
    }
}
