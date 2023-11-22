package ru.dynamika.biblioclub.book.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "Название не может быть пустым.")
    private String name;

    @Column
    @NotBlank(message = "Автор не может отсутствовать.")
    private String author;

    @Column
    @NotBlank(message = "Номер не может отсутствовать.")
    private String ISBN;
}
