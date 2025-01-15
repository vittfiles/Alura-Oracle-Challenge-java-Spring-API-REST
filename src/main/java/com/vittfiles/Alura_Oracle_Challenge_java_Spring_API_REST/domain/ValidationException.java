package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain;

public class ValidationException extends RuntimeException{

    public ValidationException(String message){
        super(message);
    }
}
