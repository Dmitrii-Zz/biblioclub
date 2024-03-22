package ru.dynamika.biblioclub.exceptions.ex;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(final String mess) {
        super(mess);
    }
}
