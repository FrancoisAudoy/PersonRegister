package fr.francoisaudoy.personregister.controller;

import fr.francoisaudoy.personregister.model.PersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class RegisterControllerTest {

    @Autowired
    private RegisterController controller;

    private final PersonDto personWithFullInformations = new PersonDto("Francois", "18/07/1994", "France", "0608854560", "Male");
    private final PersonDto personWithoutOptionalInformations = new PersonDto("Francois", "18/07/1994", "France", "", "");

    @Test
    @Disabled ("WIP")
    void addPersonSuccess() {
    }

    @DisplayName("Find person with success and full information")
    @Test
    @Disabled("Initiating DB")
    void findPersonInformationSuccess() {
        ResponseEntity<String> res = controller.findPersonInformation("0");
        Assertions.assertNotNull(res);
        Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());
        Assertions.assertEquals(personWithFullInformations.toString(),
                res.getBody());
    }


}