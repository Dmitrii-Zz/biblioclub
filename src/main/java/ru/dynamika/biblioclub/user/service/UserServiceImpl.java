package ru.dynamika.biblioclub.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamika.biblioclub.exceptions.ex.UserNotFoundException;
import ru.dynamika.biblioclub.user.model.User;
import ru.dynamika.biblioclub.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userStorage;

    @Override
    public User createUser(User user) {
        return userStorage.save(user);
    }

    @Override
    public User updateUser(User user, long userId) {
        User updateUser = checkUser(userId);

        if (user.getName() != null) {
            updateUser.setName(user.getName());
        }

        if (user.getBirthday() != null) {
            updateUser.setBirthday(user.getBirthday());
        }

        return userStorage.save(updateUser);

    }

    @Override
    public List<User> getAllUsers() {
        return userStorage.findAll();
    }

    private User checkUser(long userId) {
        Optional<User> optUser = userStorage.findById(userId);

        if (optUser.isEmpty()) {
            throw new UserNotFoundException(String.format("User с id = %d не найден", userId));
        }

        return optUser.get();
    }
}
