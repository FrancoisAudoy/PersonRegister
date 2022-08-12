package fr.francoisaudoy.personregister.controller;

import fr.francoisaudoy.personregister.exception.UserNotFoundException;
import fr.francoisaudoy.personregister.model.PersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@SpringBootTest
class RegisterControllerTest {

    @Autowired
    private RegisterController controller;

    private final PersonDto personWithFullInformation = new PersonDto("Francois", new Date("18/07/1994"), "France", "0608854560", "Male");
    private final PersonDto personWithoutOptionalInformation = new PersonDto("Francois", new Date("18/07/1994"), "France", "", "");

    @DisplayName("Successfully add person")
    @Test
    void addPersonSuccess() {
        ResponseEntity<Long> res1 = controller.addPerson(personWithFullInformation);
        Assertions.assertNotNull(res1);
        Assertions.assertEquals(HttpStatus.OK,res1.getStatusCode());
        Long body1 = res1.getBody();

        ResponseEntity<Long> res2 = controller.addPerson(personWithoutOptionalInformation);
        Assertions.assertNotNull(res2);
        Assertions.assertEquals(HttpStatus.OK,res2.getStatusCode());
        Long body2 = res2.getBody();

        Assertions.assertNotEquals(body1, body2);
    }

    @DisplayName("Find person with success")
    @Test
    void findPersonInformationSuccess() throws UserNotFoundException {
        controller.addPerson(personWithFullInformation);
        ResponseEntity<PersonDto> res = controller.findPersonInformation(1l);
        Assertions.assertNotNull(res);
        Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());
        Assertions.assertEquals(personWithFullInformation,
                res.getBody());

        controller.addPerson(personWithoutOptionalInformation);
        ResponseEntity<PersonDto> res2 = controller.findPersonInformation(2l);
        Assertions.assertNotNull(res2);
        Assertions.assertEquals(HttpStatus.OK, res2.getStatusCode());
        Assertions.assertEquals(personWithoutOptionalInformation,
                res2.getBody());
    }

    @DisplayName("Failed to add person")
    @Test
    void failedAddPerson() {
        Assertions.assertThrowsExactly(NullPointerException.class, () -> controller.addPerson(null));
    }

    @DisplayName("Failed to find person")
    @Test
    void failedFindPerson() {
        Assertions.assertThrowsExactly(UserNotFoundException.class, () -> controller.findPersonInformation(0L));
    }
}