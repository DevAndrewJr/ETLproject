package it.projects.SQLserverProject.exception;

import lombok.experimental.*;

@StandardException
public class JsonPlaceholderUserListNotFoundException extends RuntimeException {
    public JsonPlaceholderUserListNotFoundException(String message) {
        super(message);
    }
}
