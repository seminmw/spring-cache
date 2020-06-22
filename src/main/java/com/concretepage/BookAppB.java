package com.concretepage;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class BookAppB {
	Book book = new Book();
	BookStore bookStore = new BookStore();
	@Cacheable(value = "book")
	public Book getBook() {
		System.out.println("Executing getBook method...");
		book.setBookName("Mahabharat");
		return book;
	}
	@Cacheable(value = "bookstore")
	public BookStore getBookStore() {
		System.out.println("Executing getBookStore method...");
		bookStore.setBookStoreName("Sri Krishna Book Store");
		return bookStore;
	}
}
