package ru.dynamika.biblioclub.rental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.dynamika.biblioclub.book.model.Book;
import ru.dynamika.biblioclub.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "rentals")
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column
    @NotNull(message = "Дата взятия книги не может быть пустой.")
    private LocalDate dateRental;
}
