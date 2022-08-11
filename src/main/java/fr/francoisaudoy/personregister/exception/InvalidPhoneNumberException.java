package fr.francoisaudoy.personregister.exception;

public class InvalidPhoneNumberException extends PersonRegisterException {
    public InvalidPhoneNumberException(String message) {
        super(message, "INVALID_FIELD_PHONE_NUMBER");
    }
}
