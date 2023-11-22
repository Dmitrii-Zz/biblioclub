package ru.dynamika.biblioclub.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dynamika.biblioclub.user.model.User;
import ru.dynamika.biblioclub.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userStorage;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user, long userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
