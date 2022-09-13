package s22.bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import s22.bookstore.domain.Book;

@Controller
public class BookController {
	
	private ArrayList<Book> books = new ArrayList<>();
	
	@GetMapping("/book")
	public String showBooks(Model model) {
		model.addAttribute("booksList", "books");
		model.addAttribute("book", new Book());
		return "books";		
	}
	
	@PostMapping("/book")
	public String addBook(Book kirja) {
		books.add(kirja);
		return "redirect:/book";
	}

}
