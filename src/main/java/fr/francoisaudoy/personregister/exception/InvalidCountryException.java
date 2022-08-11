package fr.francoisaudoy.personregister.exception;

public class InvalidCountryException extends PersonRegisterException {
    public InvalidCountryException(String message) {
        super(message, "INVALID_FIELD_COUNTRY");
    }
}
