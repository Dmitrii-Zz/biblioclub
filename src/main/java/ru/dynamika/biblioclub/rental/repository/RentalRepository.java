package ru.dynamika.biblioclub.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dynamika.biblioclub.rental.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
