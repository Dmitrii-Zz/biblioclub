package ru.dynamika.biblioclub.user.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "Имя не может быть пустым.")
    private String name;

    @Column
    @NotNull(message = "Дата рождения не может отсутствовать.")
    private LocalDate birthday;
}
