package ru.dynamika.biblioclub.rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamika.biblioclub.book.service.BookService;
import ru.dynamika.biblioclub.rental.Mapper.RentalMapper;
import ru.dynamika.biblioclub.rental.dto.RentalDto;
import ru.dynamika.biblioclub.rental.model.Rental;
import ru.dynamika.biblioclub.rental.repository.RentalRepository;
import ru.dynamika.biblioclub.user.model.User;
import ru.dynamika.biblioclub.book.model.Book;
import ru.dynamika.biblioclub.user.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalStorage;
    private final UserService userService;
    private final BookService bookService;

    @Override
    public List<RentalDto> getAllRental() {
        return rentalStorage.findAll().stream()
                .map(RentalMapper::toRentalDto)
                .collect(Collectors.toList());
    }

    @Override
    public Rental createRental(long userId, long bookId) {
        return rentalStorage.save(buildRental(userId, bookId));
    }

    private Rental buildRental(long userId, long bookId) {
        User user = userService.checkUser(userId);
        Book book = bookService.checkExistsBook(bookId);
        Rental rental = new Rental();
        rental.setUser(user);
        rental.setBook(book);
        rental.setDateRental(LocalDate.now());
        return rental;
    }
}
