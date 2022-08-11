package fr.francoisaudoy.personregister.controller;

import fr.francoisaudoy.personregister.model.PersonDto;
import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import fr.francoisaudoy.personregister.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@Controller
@RequestMapping(path = "/person")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping(value = "/information/{personId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> findPersonInformation(@PathVariable(name = "personId") Long id) throws Exception {
        return ResponseEntity.ok(registerService.getPersonInformation(id));
    }

    @PutMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> addPerson(@RequestBody @Valid PersonDto person) {
        PersonEntity entity = registerService.createPerson(person);
        return ResponseEntity.ok(entity.getId());
    }
}