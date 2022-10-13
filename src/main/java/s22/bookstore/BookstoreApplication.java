package s22.bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import s22.bookstore.domain.ApplicationUser;
import s22.bookstore.domain.ApplicationUserRepository;
import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.Category;
import s22.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	BookRepository repository;
	@Autowired
	CategoryRepository crepository;
	@Autowired
	ApplicationUserRepository appUserRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
			log.info("luodaan käyttäjiä");
			appUserRepository.save(new ApplicationUser("Milja", "Haiko", "USER", "user", "$2a$10$4ntuMyekyZTeKd6klNdTsO1kIEKtOJk2SUcI5Aw7GILJ6iRClVzWe"));
			appUserRepository.save(new ApplicationUser("Laura", "Kanala", "ADMIN", "admin", "$2a$10$7phz2seoS1NhIVdzdpMhxuto0GRX46a33nmIbumXqDd1ZLEA77A/K"));
		
			log.info("save a couple of books");
			crepository.save(new Category("Novel"));
			crepository.save(new Category("Detective"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Children"));
			
			repository.save(new Book("Loistava ystäväni", "Elena Ferrante", "1234", 25, 2016, crepository.findByName("Novel").get(0)));
			repository.save(new Book("Hildur", "Satu Rämö", "56285628", 35, 2022, crepository.findByName("Detective").get(0)));
				
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		
	}
}
