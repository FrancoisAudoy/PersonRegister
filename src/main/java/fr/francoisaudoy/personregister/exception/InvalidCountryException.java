package fr.francoisaudoy.personregister.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCountryException extends PersonRegisterException {
    public InvalidCountryException(String message) {
        super(message, "INVALID_FIELD_COUNTRY");
    }
}
