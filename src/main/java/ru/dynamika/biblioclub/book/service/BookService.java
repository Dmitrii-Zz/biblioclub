package ru.dynamika.biblioclub.book.service;

import ru.dynamika.biblioclub.book.model.Book;
import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book updateBook(Book book, long bookId);

    List<Book> getAllBook();
}
