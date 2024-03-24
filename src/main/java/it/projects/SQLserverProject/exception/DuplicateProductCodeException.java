package it.projects.SQLserverProject.exception;

import lombok.experimental.StandardException;

@StandardException
public class DuplicateProductCodeException extends RuntimeException {

    public DuplicateProductCodeException(String message) {
        super(message);

    }


}
