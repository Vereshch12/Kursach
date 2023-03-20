package com.example.kursach;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceptionQuestion extends RuntimeException{
    public ExceptionQuestion(String message) {
        super(message);
    }
}
