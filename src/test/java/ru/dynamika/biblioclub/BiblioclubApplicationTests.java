package ru.dynamika.biblioclub;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dynamika.biblioclub.book.controller.BookController;
import ru.dynamika.biblioclub.book.model.Book;
import ru.dynamika.biblioclub.user.controller.UserController;
import ru.dynamika.biblioclub.user.model.User;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BiblioclubApplicationTests {

	private final UserController userController;
	private final BookController bookController;

	@Test
	void contextLoads() {
		User user = new User();
		user.setName("Золотухин Дмитрий Евгеньевич");
		user.setBirthday(LocalDate.of(1950, 6, 16));
		User userSave = userController.createUser(user);

		assertAll("Проверка создания юзера",
				() -> assertEquals(1, userSave.getId()));

		List<User> users = userController.getAllUser();

		assertEquals(1, users.size());

		user.setName("Николай Николаевич Николаенко");
		user.setBirthday(LocalDate.of(1970, 5, 15));

		User userUpdate = userController.updateUser(user, 1);

		assertAll("Проверка обновления юзера",
				() -> assertEquals(1, userUpdate.getId()),
				() -> assertEquals("Николай Николаевич Николаенко", userUpdate.getName()),
				() -> assertEquals(LocalDate.of(1970, 5, 15), userUpdate.getBirthday()));

		Book book = new Book();
		book.setName("Степь");
		book.setAuthor("Антон Чехов");
		book.setISBN("234-2323");

		Book bookSave = bookController.createBook(book);

		assertAll("Проверка создания книги",
				() -> assertEquals(1, bookSave.getId()));

		List<Book> books = bookController.getAllBook();

		assertEquals(1, books.size());

		book.setName("Рассказы");
		book.setAuthor("Неизвестный автор");
		book.setISBN("889-87");

		Book updateBook = bookController.updateBook(book, 1);

		assertAll("Проверка обновления книги",
				() -> assertEquals(1, updateBook.getId()),
				() -> assertEquals("Рассказы", updateBook.getName()),
				() -> assertEquals("889-87", updateBook.getISBN()));
	}
}