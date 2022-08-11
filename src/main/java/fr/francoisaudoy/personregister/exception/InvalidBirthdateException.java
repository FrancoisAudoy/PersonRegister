package fr.francoisaudoy.personregister.exception;


public class InvalidBirthdateException extends PersonRegisterException {

    public InvalidBirthdateException(String msg) {
        super(msg, "INVALID_FIELD_BIRTHDATE");
    }
}
