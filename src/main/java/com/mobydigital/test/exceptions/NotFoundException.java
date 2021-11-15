package com.mobydigital.test.exceptions;

import lombok.extern.java.Log;

@Log
public class NotFoundException extends Exception{
    private final Long id;

    public NotFoundException(String message,Long id) {
        super(message);
        this.id = id;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + id;
    }

    @Override
    public void printStackTrace() {
        log.warning(getMessage());
    }
}
