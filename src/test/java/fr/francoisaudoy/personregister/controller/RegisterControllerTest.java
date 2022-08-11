package fr.francoisaudoy.personregister.controller;

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

    @Test
    void addPersonSuccess() {
        ResponseEntity<Long> res1 = controller.addPerson(personWithFullInformation);
        Assertions.assertNotNull(res1);
        Long body1 = res1.getBody();
        Assertions.assertEquals(1l, body1);
        ResponseEntity<Long> res2 = controller.addPerson(personWithoutOptionalInformation);
        Assertions.assertNotNull(res2);
        Long body2 = res2.getBody();
        Assertions.assertEquals(2l, body2);
    }

    @DisplayName("Find person with success and full information")
    @Test
    void findPersonInformationSuccess() throws Exception {
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
}