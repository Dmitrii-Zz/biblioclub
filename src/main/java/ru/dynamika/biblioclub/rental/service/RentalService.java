package ru.dynamika.biblioclub.rental.service;

import ru.dynamika.biblioclub.rental.dto.RentalDto;
import ru.dynamika.biblioclub.rental.model.Rental;

import java.util.List;

public interface RentalService {

    List<RentalDto> getAllRental();

    Rental createRental(long userId, long bookId);

}
