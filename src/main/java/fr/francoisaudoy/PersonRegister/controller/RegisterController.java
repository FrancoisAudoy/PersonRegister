package fr.francoisaudoy.PersonRegister.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/person")
public class RegisterController {

    @GetMapping(value = "/information", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findPersonInformation() {
        return "";
    }

    @PutMapping(value = "/register")
    public void addPerson() {}
}
