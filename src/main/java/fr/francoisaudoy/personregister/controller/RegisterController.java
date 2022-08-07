package fr.francoisaudoy.personregister.controller;

import fr.francoisaudoy.personregister.model.PersonDto;
import fr.francoisaudoy.personregister.model.entity.PersonEntity;
import fr.francoisaudoy.personregister.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@Controller
@RequestMapping(path = "/person")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping(value = "{personId}/information",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findPersonInformation(@PathVariable(name = "personId") String id) {
        return null;
    }

    @PutMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPerson(@RequestBody PersonDto person) {
        PersonEntity entity = registerService.createPerson(person);
        return ResponseEntity.ok(entity.toString());
    }
}
