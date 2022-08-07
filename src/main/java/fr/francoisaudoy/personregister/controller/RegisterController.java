package fr.francoisaudoy.personregister.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/person")
public class RegisterController {

    @GetMapping(value = "{personId}/information",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findPersonInformation(@PathVariable(name = "personId") String id) {
        return null;
    }

    @PutMapping(value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPerson() {
        return null;
    }
}
