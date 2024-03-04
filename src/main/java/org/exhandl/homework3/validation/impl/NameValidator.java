package org.exhandl.homework3.validation.impl;

import org.exhandl.homework3.exception.ValidationException;
import org.exhandl.homework3.validation.Validator;

public class NameValidator implements Validator {

    @Override
    public void validate(String str) throws ValidationException {
        if (!str.matches("[a-zA-Z]+")) {
            throw new ValidationException("Name string must contain only letters, but provided %s".formatted(str));
        }
    }

}
