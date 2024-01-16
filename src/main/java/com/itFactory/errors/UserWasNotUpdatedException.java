package com.itFactory.errors;

public class UserWasNotUpdatedException extends RuntimeException{
    public UserWasNotUpdatedException(String message) {
        super(message);
    }
}
