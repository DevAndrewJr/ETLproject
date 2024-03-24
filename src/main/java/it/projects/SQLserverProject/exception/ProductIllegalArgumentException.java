package it.projects.SQLserverProject.exception;

import lombok.experimental.StandardException;

@StandardException
public class ProductIllegalArgumentException extends RuntimeException {

    public ProductIllegalArgumentException(String message) {
        super(message);
    }



}
