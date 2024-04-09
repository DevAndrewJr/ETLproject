package it.projects.SQLserverProject.exception;

import lombok.experimental.StandardException;

@StandardException
public class ProductSaveException extends RuntimeException {

    public ProductSaveException(String message) {
        super(message);
    }

}
