package fr.francoisaudoy.personregister.service;

import fr.francoisaudoy.personregister.model.PersonDto;
import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import fr.francoisaudoy.personregister.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterService {

    @Autowired
    private PersonRepository repository;

    public PersonEntity createPerson(PersonDto person) {
        final PersonEntity entity = person.toEntity();

        return repository.save(entity);
    }
}
