package fr.francoisaudoy.personregister.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidUserNameException extends PersonRegisterException {

    public InvalidUserNameException(String message) {
        super(message, "INVALID_FIELD_USERNAME");
    }
}
