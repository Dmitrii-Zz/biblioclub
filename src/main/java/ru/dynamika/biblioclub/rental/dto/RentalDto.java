package ru.dynamika.biblioclub.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RentalDto {

    private long id;

    private long userId;

    private long bookId;

    private LocalDate dateRental;
}
