package com.BlogSphere.Spring_boot_project.exception;

import com.BlogSphere.Spring_boot_project.dto.ResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseDTO<String> handleException(InvalidInputException exception) {

        return new ResponseDTO<>(false,  exception.getMessage());
    }

}
