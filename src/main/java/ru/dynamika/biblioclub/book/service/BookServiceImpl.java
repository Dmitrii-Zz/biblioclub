package ru.dynamika.biblioclub.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamika.biblioclub.book.model.Book;
import ru.dynamika.biblioclub.book.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookStorage;

    @Override
    public Book createBook(Book book) {
        return bookStorage.save(book);
    }

    @Override
    public Book updateBook(Book book, long bookId) {
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        return null;
    }
}
