package org.exhandl.homework3;

import org.exhandl.homework3.data.Person;
import org.exhandl.homework3.data.ValidationGroup;
import org.exhandl.homework3.exception.ValidationException;
import org.exhandl.homework3.service.PersonService;
import org.exhandl.homework3.service.ValidatorFactory;
import org.exhandl.homework3.util.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String STOP_CMD = "stop";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        PersonService personService = new PersonService(new ValidatorFactory());
        List<Person> persons = new ArrayList<>();

        ValidationGroup validationGroup = null;
        while (true) {
            try {
                System.out.println("Write input line or stop:");
                String input = SCANNER.nextLine();
                if (STOP_CMD.equals(input)) {
                    break;
                }
                validationGroup = personService.validateFuturePerson(input);
                if (!validationGroup.getValidationExceptions().isEmpty()) {
                    throw new ValidationException("Validation error appeared");
                }
                persons.add(personService.getPersonFromInput(input));
            } catch (ValidationException e) {
                validationGroup.getValidationExceptions().forEach(ex -> System.err.println(ex.getMessage()));
            }
        }
        Map<String, List<Person>> groupedPersons = personService.groupPersonsByLastName(persons);
        if (groupedPersons != null) {
            for (Map.Entry<String, List<Person>> entry : groupedPersons.entrySet()) {
                try {
                    JsonUtils.saveAsJsonFile(entry.getKey(), entry.getValue());
                } catch (IOException e) {
                    System.err.printf("Can not save into file %s. %s Skip it%n", entry.getKey(), e.getMessage());
                }
            }
        }
    }

}
