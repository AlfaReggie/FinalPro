package org.exhandl.homework3.validation.impl;

import org.exhandl.homework3.exception.ValidationException;
import org.exhandl.homework3.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements Validator {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public void validate(String str) throws ValidationException {
        try {
            LocalDate.parse(str, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new ValidationException("Wrong date input. Expected dd.MM.yyyy, but provided %s".formatted(str));
        }
    }

}
