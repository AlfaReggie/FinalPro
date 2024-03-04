package org.exhandl.homework3.service;

import org.exhandl.homework3.data.AttributeType;
import org.exhandl.homework3.validation.Validator;
import org.exhandl.homework3.validation.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ValidatorFactory {

    private final Map<AttributeType, Validator> validators;

    public ValidatorFactory() {
        this.validators = new HashMap<>(5);
        validators.put(AttributeType.DATE, new DateValidator());
        validators.put(AttributeType.GENDER, new GenderValidator());
        validators.put(AttributeType.INPUT_LENGTH, new InputCountValidator());
        validators.put(AttributeType.STR_NAME, new NameValidator());
        validators.put(AttributeType.PHONE_NUMBER, new PhoneNumberValidator());
    }

    public Validator getValidator(AttributeType type) {
        return validators.get(type);
    }

}
