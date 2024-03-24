package it.projects.SQLserverProject.exception;

import lombok.experimental.StandardException;

@StandardException
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }



}
