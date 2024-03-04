package org.exhandl.homework3.validation;

import org.exhandl.homework3.exception.ValidationException;

public interface Validator {

    void validate(String str) throws ValidationException;

}
