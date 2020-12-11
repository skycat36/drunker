package com.vsu.drunker.web.validation;

import com.vsu.drunker.web.data.errors.BadRequestDTO;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidationUtils {
    private static final Validator VALIDATOR = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    public static BadRequestDTO validationObject(Object valObject, Class<?>... layersValidation) {
        if (valObject == null) {
            return null;
        }
        Map<String, String> errors = VALIDATOR.validate(valObject, layersValidation).stream().collect(Collectors.toMap(
                entry -> entry.getPropertyPath().toString(), ConstraintViolation::getMessage
        ));
        return errors.isEmpty() ? null : new BadRequestDTO(errors);
    }
}
