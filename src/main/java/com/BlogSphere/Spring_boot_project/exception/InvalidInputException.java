package com.BlogSphere.Spring_boot_project.exception;

import com.BlogSphere.Spring_boot_project.dto.UserDTO;

public class InvalidInputException extends RuntimeException{

    String message;

    public InvalidInputException(String message) {
        super(message);
        this.message = message;
    }


    }

