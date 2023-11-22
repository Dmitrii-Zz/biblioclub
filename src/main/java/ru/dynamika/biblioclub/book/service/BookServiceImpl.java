package ru.dynamika.biblioclub.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamika.biblioclub.book.model.Book;
import ru.dynamika.biblioclub.book.repository.BookRepository;
import ru.dynamika.biblioclub.exceptions.ex.BookNotFoundException;

import java.util.List;
import java.util.Optional;

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
        Book updateBook = checkExistsBook(bookId);

        if (book.getName() != null) {
            updateBook.setName(book.getName());
        }

        if (book.getAuthor() != null) {
            updateBook.setAuthor(book.getAuthor());
        }

        if (book.getISBN() != null) {
            updateBook.setISBN(book.getISBN());
        }

        return bookStorage.save(updateBook);
    }

    @Override
    public List<Book> getAllBook() {
        return bookStorage.findAll();
    }

    private Book checkExistsBook(long bookId) {
        Optional<Book> optBook = bookStorage.findById(bookId);

        if (optBook.isEmpty()) {
            throw new BookNotFoundException("Отсутствует книга с id = " + bookId);
        }

        return optBook.get();
    }
}
