package org.exhandl.homework3.data;

import org.exhandl.homework3.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class ValidationGroup {
    private final List<ValidationException> validationExceptions = new ArrayList<>();

    public List<ValidationException> getValidationExceptions() {
        return validationExceptions;
    }

    public void addException(ValidationException ex) {
        validationExceptions.add(ex);
    }

}
