package ru.dynamika.biblioclub.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dynamika.biblioclub.user.model.User;
import ru.dynamika.biblioclub.user.service.UserService;
import ru.dynamika.biblioclub.user.service.UserServiceImpl;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private UserService service;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        log.info("Запрос на создание юзера: " + user.getName());
        return service.createUser(user);
    }

    @PatchMapping("/{userId}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable long userId) {
        log.info("Запрос на обновление юзера: " + userId);
        return service.updateUser(user, userId);
    }

    @GetMapping
    public List<User> getAllUser() {
        log.info("Запрос всех пользователей");
        return service.getAllUsers();
    }
}