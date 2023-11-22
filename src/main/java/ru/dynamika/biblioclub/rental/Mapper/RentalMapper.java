package ru.dynamika.biblioclub.rental.Mapper;

import ru.dynamika.biblioclub.rental.dto.RentalDto;
import ru.dynamika.biblioclub.rental.model.Rental;

public class RentalMapper {
    public static RentalDto toRentalDto(Rental rental) {
        return RentalDto.builder()
                .id(rental.getId())
                .bookId(rental.getBook().getId())
                .userId(rental.getUser().getId())
                .dateRental(rental.getDateRental())
                .build();
    }
}
