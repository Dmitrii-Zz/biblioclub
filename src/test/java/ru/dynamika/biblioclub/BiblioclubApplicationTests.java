package ru.dynamika.biblioclub;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dynamika.biblioclub.user.controller.UserController;
import ru.dynamika.biblioclub.user.model.User;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BiblioclubApplicationTests {

	private final UserController userController;

	@Test
	void contextLoads() {
		User user = new User();
		user.setName("Золотухин Дмитрий Евгеньевич");
		user.setBirthday(LocalDate.of(1950, 6, 16));
		User userSave = userController.createUser(user);

		assertAll("Проверка создания юзера",
				() -> assertEquals(1, user.getId()));

		List<User> users = userController.getAllUser();

		assertEquals(1, users.size());

		user.setName("Николай Николаевич Николаенко");
		user.setBirthday(LocalDate.of(1970, 5, 15));

		User userUpdate = userController.updateUser(user, 1);

		assertAll("Проверка обновления юзера",
				() -> assertEquals(1, userUpdate.getId()),
				() -> assertEquals("Николай Николаевич Николаенко", userUpdate.getName()),
				() -> assertEquals(LocalDate.of(1970, 5, 15), userUpdate.getBirthday()));

	}

}
