package it.projects.SQLserverProject.exception;

import lombok.experimental.*;


@StandardException
public class JsonPlaceholderUserNotFoundException extends RuntimeException {
    public JsonPlaceholderUserNotFoundException(String message) {
        super(message);
    }
}
