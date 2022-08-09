package fr.francoisaudoy.personregister.service;

import fr.francoisaudoy.personregister.logger.BeforeLog;
import fr.francoisaudoy.personregister.model.PersonDto;
import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import fr.francoisaudoy.personregister.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RegisterService {

    @Autowired
    private PersonRepository repository;

    @BeforeLog
    public PersonEntity createPerson(PersonDto person) {
        final PersonEntity entity = person.toEntity();

        return repository.save(entity);
    }

    @BeforeLog
    public PersonDto getPersonInformation(Long id) throws Exception {
        Optional<PersonEntity> optionalEntity = repository.findById(id);
        if(optionalEntity.isEmpty())
            throw new Exception("User does not exist");
        return optionalEntity.get().toDto();
    }
}
