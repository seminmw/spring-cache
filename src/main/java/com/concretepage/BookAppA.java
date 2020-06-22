package com.concretepage;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class BookAppA {
	Book book = new Book();
	@Cacheable(value = "mycache")
	public Book getBook() {
		System.out.println("Executing getBook method...");
		book.setBookName("Mahabharat");
		return book;
	}
}