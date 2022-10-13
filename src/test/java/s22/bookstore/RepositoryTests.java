package s22.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s22.bookstore.domain.ApplicationUserRepository;
import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.CategoryRepository;

@DataJpaTest
class RepositoryTests {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository crepository;
	
	@Autowired
	ApplicationUserRepository appUserRepository;
	
	
	@Test
	public void findBook() {
		Book book = bookRepository.findById((long) 1).get();
		System.out.println("Haetaan id 7" + book);
		assertEquals(book.getTitle(), "Loistava ystäväni");
	}

	@Test
	public void insertNewBook() {
		Book book = new Book("Kuka kaappasi auringon", "Mauri Kunnas", "978-951-1-39579-9", 17.9, 2021, crepository.findByName("Children").get(0));
		bookRepository.save(book);
		assertNotNull(book.getId());
	}
	
	@Test
	public void deleteBook() {
		Optional<Book>poistettava = bookRepository.findById((long) 2);
		bookRepository.deleteById(poistettava.get().getId());
	}
}
