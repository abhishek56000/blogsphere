package com.BlogSphere.Spring_boot_project.exception;

public class InvalidInputException extends RuntimeException{

    String message;

    public InvalidInputException(String message) {
        super(message);
        this.message = message;
    }
}
