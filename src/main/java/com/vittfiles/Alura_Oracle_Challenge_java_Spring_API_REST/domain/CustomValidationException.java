package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain;

public class CustomValidationException extends RuntimeException{

    public CustomValidationException(String message){
        super(message);
    }
}
