package ru.dynamika.biblioclub.rental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dynamika.biblioclub.rental.dto.RentalDto;
import ru.dynamika.biblioclub.rental.model.Rental;
import ru.dynamika.biblioclub.rental.service.RentalService;

import java.util.List;

@RestController
@RequestMapping(path = "/rental")
@RequiredArgsConstructor
@Slf4j
public class RentalController {
    private final RentalService service;

    @PostMapping("/{bookId}")
    public Rental createRental(@RequestHeader("X-User-Header") long userId,
                               @PathVariable long bookId) {
        return service.createRental(userId, bookId);
    }

    @GetMapping
    public List<RentalDto> getAllRental() {
        return service.getAllRental();
    }
}
