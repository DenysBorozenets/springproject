package com.denis.springproject.exception;

public class UserNotFoundException extends Throwable{
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
