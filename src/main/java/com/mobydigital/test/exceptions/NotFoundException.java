package com.mobydigital.test.exceptions;

public class NotFoundException extends RuntimeException{
    private Long id;

    public NotFoundException(String message,Long id) {
        super(message);
        this.id = id;
    }
}
