package ru.dynamika.biblioclub.rental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dynamika.biblioclub.rental.model.Rental;
import ru.dynamika.biblioclub.rental.service.RentalService;

import java.util.List;

@RestController
@RequestMapping(path = "/rental")
@RequiredArgsConstructor
@Slf4j
public class RentalController {
    private RentalService service;

    @GetMapping
    public List<Rental> getAllRental() {
        return service.getAllRental();
    }
}
