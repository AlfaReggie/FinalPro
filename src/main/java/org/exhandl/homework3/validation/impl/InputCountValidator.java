package org.exhandl.homework3.validation.impl;

import org.exhandl.homework3.exception.ValidationException;
import org.exhandl.homework3.validation.Validator;

public class InputCountValidator implements Validator {

    @Override
    public void validate(String str) throws ValidationException {
        int length = str.split(" ").length;
        if (length != 6) {
            throw new ValidationException("Argument size is wrong. Must be 6, but provided %d".formatted(length));
        }
    }

}
