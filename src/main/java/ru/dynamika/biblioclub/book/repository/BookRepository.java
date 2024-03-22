package ru.dynamika.biblioclub.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dynamika.biblioclub.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
