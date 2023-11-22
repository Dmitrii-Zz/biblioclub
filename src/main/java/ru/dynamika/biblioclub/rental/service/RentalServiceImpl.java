package ru.dynamika.biblioclub.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamika.biblioclub.rental.model.Rental;
import ru.dynamika.biblioclub.rental.repository.RentalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalStorage;
    @Override
    public List<Rental> getAllRental() {
        return rentalStorage.findAll();
    }

    @Override
    public Rental createRental(long userId, long bookId) {
        return null;
    }
}
