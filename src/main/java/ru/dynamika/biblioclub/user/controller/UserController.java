package ru.dynamika.biblioclub.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dynamika.biblioclub.user.model.User;
import ru.dynamika.biblioclub.user.service.UserServiceImpl;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private UserServiceImpl userService;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        log.info("Запрос на создание юзера: " + user.getName());
        return null;
    }

    @PatchMapping("/{userId}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable long userId) {
        log.info("Запрос на обновление юзера: " + userId);
        return null;
    }

    @GetMapping
    public List<User> getAllUser() {
        log.info("Запрос всех пользователей");
        return null;
    }
}