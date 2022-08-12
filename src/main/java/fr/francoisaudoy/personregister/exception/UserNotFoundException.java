package fr.francoisaudoy.personregister.exception;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends PersonRegisterException {
    public UserNotFoundException(String message) {
        super(message, "USER_NOT_FOUND");
    }
}
