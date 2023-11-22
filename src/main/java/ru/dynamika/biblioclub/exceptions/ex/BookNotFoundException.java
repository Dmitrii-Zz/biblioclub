package ru.dynamika.biblioclub.exceptions.ex;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(final String mess) {
        super(mess);
    }
}
