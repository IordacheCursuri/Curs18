package com.itFactory.errors;

public class UserWasNotDeletedException extends RuntimeException {

    public UserWasNotDeletedException(String message) {
        super(message);
    }
}
