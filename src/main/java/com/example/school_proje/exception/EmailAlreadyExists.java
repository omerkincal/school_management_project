package com.example.school_proje.exception;

public class EmailAlreadyExists extends RuntimeException{
    private String message;

    public EmailAlreadyExists(String message){
        super(message);
    }

}
