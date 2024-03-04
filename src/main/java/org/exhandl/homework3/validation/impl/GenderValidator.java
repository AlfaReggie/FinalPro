package org.exhandl.homework3.validation.impl;

import org.exhandl.homework3.exception.ValidationException;
import org.exhandl.homework3.validation.Validator;

public class GenderValidator implements Validator {

    @Override
    public void validate(String str) throws ValidationException {
        if (!str.matches("[fm]")) {
            throw new ValidationException("Wrong input for gender. Expected m or f, but provided %s".formatted(str));
        }
    }

}
