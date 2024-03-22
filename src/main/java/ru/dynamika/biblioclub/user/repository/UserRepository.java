package ru.dynamika.biblioclub.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dynamika.biblioclub.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
