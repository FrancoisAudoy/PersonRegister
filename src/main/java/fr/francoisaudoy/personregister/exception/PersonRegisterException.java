package fr.francoisaudoy.personregister.exception;

import lombok.Getter;
import lombok.Setter;


public abstract class PersonRegisterException extends Exception {
    @Getter
    @Setter
    protected String errorCode;

    public PersonRegisterException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
