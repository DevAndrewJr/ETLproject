package it.projects.h2project.config;

import it.projects.h2project.entity.*;

import it.projects.h2project.exception.DuplicateProductCodeException;
import it.projects.h2project.exception.ProductIllegalArgumentException;
import it.projects.h2project.exception.ProductNotFoundException;
import it.projects.h2project.exception.ProductSaveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateProductCodeException.class)
    public ResponseEntity<String> handleDuplicateProductCodeException(DuplicateProductCodeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ProductIllegalArgumentException.class)
    public ResponseEntity<String> handleProductIllegalArgumentException(ProductIllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        List<Product> emptyProductList = new ArrayList<>();
        emptyProductList.add(new Product());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + "\n" + emptyProductList);
    }

    @ExceptionHandler(ProductSaveException.class)
    public ResponseEntity<String> handleProductSaveException(ProductSaveException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
