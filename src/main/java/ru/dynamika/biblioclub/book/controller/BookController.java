package ru.dynamika.biblioclub.book.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dynamika.biblioclub.book.model.Book;
import ru.dynamika.biblioclub.book.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService service;

    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {
        log.info("Запрос на создание книги: " + book.getName());
        return service.createBook(book);
    }

    @PatchMapping
    public Book updateBook(@Valid @RequestBody Book book, @PathVariable long bookId) {
        log.info("Запрос на обновление книги: " + bookId);
        return service.updateBook(book, bookId);
    }

    @GetMapping
    public List<Book> getAllBook() {
        log.info("Запрос всех книг.");
        return service.getAllBook();
    }
}
