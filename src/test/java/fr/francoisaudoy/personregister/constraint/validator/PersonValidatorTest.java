package fr.francoisaudoy.personregister.constraint.validator;

import fr.francoisaudoy.personregister.exception.InvalidBirthdateException;
import fr.francoisaudoy.personregister.exception.InvalidCountryException;
import fr.francoisaudoy.personregister.exception.InvalidPhoneNumberException;
import fr.francoisaudoy.personregister.exception.InvalidUserNameException;
import fr.francoisaudoy.personregister.model.PersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class PersonValidatorTest {

    private final PersonDto personWithFullInformation = new PersonDto("Francois", new Date("18/07/1994"), "FRANCE", "0608854560", "Male");
    private final PersonDto personWithoutOptionalInformation = new PersonDto("Francois", new Date("18/07/1994"), "FRANCE", "", "");

    private static PersonValidator validator;

    @BeforeAll
    static void initValidator(){
        validator = new PersonValidator();
        validator.setValidCountry("FRANCE");
        validator.setMinimalAge((short) 18);
    }

    @Test
    void isValid() {
        Assertions.assertTrue(validator.isValid(personWithFullInformation, null));
        Assertions.assertTrue(validator.isValid(personWithoutOptionalInformation, null));
    }

    @Test
    void isValidException() {
        final PersonDto invalidName = new PersonDto("", new Date("18/07/1994"), "FRANCE", "0608854560", "MALE");
        Assertions.assertThrowsExactly(InvalidUserNameException.class,() -> validator.isValid(invalidName, null));

        final PersonDto invalidBirthdateTooYoung = new PersonDto("Francois", new Date("18/07/2010"), "FRANCE", "0608854560", "MALE");
        Assertions.assertThrowsExactly(InvalidBirthdateException.class,() -> validator.isValid(invalidBirthdateTooYoung, null));

        final PersonDto invalidBirthdateInFuture = new PersonDto("Francois", new Date("18/07/2029"), "FRANCE", "0608854560", "MALE");
        Assertions.assertThrowsExactly(InvalidBirthdateException.class,() -> validator.isValid(invalidBirthdateInFuture, null));

        final PersonDto invalidCountry = new PersonDto("Francois", new Date("18/07/1994"), "Allemagne", "0608854560", "MALE");
        Assertions.assertThrowsExactly(InvalidCountryException.class,() -> validator.isValid(invalidCountry, null));

        final PersonDto invalidPhoneNumber = new PersonDto("Francois", new Date("18/07/1994"), "FRANCE", "06088", "MALE");
        Assertions.assertThrowsExactly(InvalidPhoneNumberException.class,() -> validator.isValid(invalidPhoneNumber, null));

        final PersonDto invalidPerson = new PersonDto("", null, "", "06", "MALE");
        Assertions.assertThrowsExactly(InvalidUserNameException.class,() -> validator.isValid(invalidPerson, null));
    }
}