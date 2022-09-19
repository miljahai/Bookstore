package s22.bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.Category;
import s22.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Novel"));
			crepository.save(new Category("Detective"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Scifi"));
			
			repository.save(new Book("Loistava ystäväni", "Elena Ferrante", "1234", 25, 2016, crepository.findByName("Novel").get(0)));
			repository.save(new Book("Hildur", "Satu Rämö", "56285628", 35, 2022, crepository.findByName("Detective").get(0)));
				log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
