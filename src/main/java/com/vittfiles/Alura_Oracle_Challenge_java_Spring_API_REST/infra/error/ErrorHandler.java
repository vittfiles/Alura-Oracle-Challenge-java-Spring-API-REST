package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.infra.error;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(DataErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity handleCustomValidationException(CustomValidationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity handleError400(AuthenticationException e){
//        return ResponseEntity.badRequest().build();
//    }

    private record DataErrorValidation(String field, String error){
        public DataErrorValidation(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }
}
