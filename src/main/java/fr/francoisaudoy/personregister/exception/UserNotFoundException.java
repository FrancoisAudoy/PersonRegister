package fr.francoisaudoy.personregister.exception;

public class UserNotFoundException extends PersonRegisterException {
    public UserNotFoundException(String message) {
        super(message, "USER_NOT_FOUND");
    }
}
