package ru.dynamika.biblioclub.user.service;

import ru.dynamika.biblioclub.user.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user, long userId);

    List<User> getAllUsers();

    User checkUser(long userId);
}
