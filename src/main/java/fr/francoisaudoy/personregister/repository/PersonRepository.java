package fr.francoisaudoy.personregister.repository;

import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

}
