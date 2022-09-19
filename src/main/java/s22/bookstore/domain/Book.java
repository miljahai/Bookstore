package s22.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String title, author, isbn;
	private double price;
	private int bookyear;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {
		super();
		
	}

	public Book(Long id, String title, String author, String isbn, double price, int bookyear) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookyear = bookyear;
	}

	public Book(String title, String author, String isbn, double price, int bookyear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookyear = bookyear;
	}

	public Book(String title, String author, String isbn, double price, int bookyear, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookyear = bookyear;
		this.category = category;
	}
	
	public Book(Long id, String title, String author, String isbn, double price, int bookyear, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookyear = bookyear;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public int getBookyear() {
		return bookyear;
	}

	public void setBookyear(int bookyear) {
		this.bookyear = bookyear;
	}

		
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", bookyear=" + bookyear + "]";
	}
	
	

		
	
	
}
