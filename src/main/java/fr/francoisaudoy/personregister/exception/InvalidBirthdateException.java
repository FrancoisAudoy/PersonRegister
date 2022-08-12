package fr.francoisaudoy.personregister.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidBirthdateException extends PersonRegisterException {

    public InvalidBirthdateException(String msg) {
        super(msg, "INVALID_FIELD_BIRTHDATE");
    }
}
