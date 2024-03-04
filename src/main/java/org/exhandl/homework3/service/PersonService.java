package org.exhandl.homework3.service;

import org.exhandl.homework3.data.*;
import org.exhandl.homework3.exception.ValidationException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final ValidatorFactory validatorFactory;

    public PersonService(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    public ValidationGroup validateFuturePerson(String input) {
        ValidationGroup validationGroup = new ValidationGroup();
        for (Attribute attribute : toAttributes(input)) {
            try {
                validatorFactory.getValidator(attribute.getType())
                        .validate(attribute.getValue());
            } catch (ValidationException e) {
                validationGroup.addException(e);
            }
        }
        return validationGroup;

    }

    public Person getPersonFromInput(String input) throws ValidationException {
        var person = new Person();
        String[] values = input.split(" ");
        person.setLastName(values[0]);
        person.setFirstName(values[1]);
        person.setPatronymic(values[2]);
        person.setBirthDate(LocalDate.parse(values[3], DATE_FORMATTER));
        person.setPhoneNumber(values[4]);
        person.setGender(Gender.getGender(values[5]));
        return person;
    }

    private List<Attribute> toAttributes(String input) {
        List<Attribute> attributes = new ArrayList<>();
        String[] values = input.split(" ");
        try {
            attributes.add(new Attribute(AttributeType.INPUT_LENGTH, input));
            attributes.add(new Attribute(AttributeType.STR_NAME, values[0]));
            attributes.add(new Attribute(AttributeType.STR_NAME, values[1]));
            attributes.add(new Attribute(AttributeType.STR_NAME, values[2]));
            attributes.add(new Attribute(AttributeType.DATE, values[3]));
            attributes.add(new Attribute(AttributeType.PHONE_NUMBER, values[4]));
            attributes.add(new Attribute(AttributeType.GENDER, values[5]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Not enough arguments" + e.getMessage());
        }
        return attributes;
    }

    public Map<String, List<Person>> groupPersonsByLastName(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getLastName, Collectors.mapping(Function.identity(), Collectors.toList())));
    }

}
