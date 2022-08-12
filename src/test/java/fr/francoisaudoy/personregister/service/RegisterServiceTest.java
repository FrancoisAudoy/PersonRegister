package fr.francoisaudoy.personregister.service;

import fr.francoisaudoy.personregister.exception.UserNotFoundException;
import fr.francoisaudoy.personregister.model.PersonDto;
import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterServiceTest {

    @Autowired
    private RegisterService service;

    private final PersonDto personWithFullInformation = new PersonDto("Francois", new Date("18/07/1994"), "France", "0608854560", "Male");
    private final PersonDto personWithoutOptionalInformation = new PersonDto("Francois", new Date("18/07/1994"), "France", "", "");

    @Test
    void createPerson() {
        final PersonEntity entity1 = service.createPerson(personWithFullInformation);
        Assertions.assertNotNull(entity1.getId());
        final PersonEntity personWithFullInformationEntity = personWithFullInformation.toEntity();
        personWithFullInformationEntity.setId(entity1.getId());
        Assertions.assertEquals(personWithFullInformationEntity,entity1);

        final PersonEntity entity2 = service.createPerson(personWithoutOptionalInformation);
        Assertions.assertNotNull(entity2.getId());
        final PersonEntity personWithoutOptionalInformationEntity = personWithoutOptionalInformation.toEntity();
        personWithoutOptionalInformationEntity.setId(entity2.getId());
        Assertions.assertEquals(personWithoutOptionalInformationEntity,entity2);
    }

    @Test
    void getPersonInformation() throws UserNotFoundException {
        service.createPerson(personWithFullInformation);
        service.createPerson(personWithoutOptionalInformation);

        Assertions.assertEquals(personWithFullInformation, service.getPersonInformation(1L));
        Assertions.assertEquals(personWithoutOptionalInformation, service.getPersonInformation(2L));
    }

    @Test
    void getPersonInformationUserNotFoundException() throws UserNotFoundException {
        Assertions.assertThrowsExactly(UserNotFoundException.class, () -> service.getPersonInformation(0L));
    }
}