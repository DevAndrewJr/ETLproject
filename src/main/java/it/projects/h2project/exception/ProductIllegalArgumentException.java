package it.projects.h2project.exception;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@StandardException
public class ProductIllegalArgumentException extends RuntimeException {

    public ProductIllegalArgumentException(String message) {
        super(message);
    }



}
