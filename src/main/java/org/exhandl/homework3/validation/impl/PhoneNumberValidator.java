package org.exhandl.homework3.validation.impl;

import org.exhandl.homework3.exception.ValidationException;
import org.exhandl.homework3.validation.Validator;

public class PhoneNumberValidator implements Validator {

    @Override
    public void validate(String str) throws ValidationException {
        if (!str.matches("^\\d{10}$")) {
            throw new ValidationException("Phone number is wrong. Expected 0000000000, but provided %s".formatted(str));
        }
    }

}
