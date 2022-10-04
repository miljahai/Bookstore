package s22.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	 BookRepository bookRepository;	
	@Autowired
	CategoryRepository crepository;
	
	@RequestMapping(value = {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("edit", bookRepository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
}
