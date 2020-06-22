package com.concretepage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class CacheDemoB {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigB.class);
		ctx.refresh();
		BookAppB bookAppB = ctx.getBean(BookAppB.class);
		//Calling getBook method first time.
		System.out.println(bookAppB.getBook().getBookName());
		//Calling getBook method second time.
		//This time, method will not execute because result is cached with "book"
		System.out.println(bookAppB.getBook().getBookName());
        System.out.println("---------------------------");
		//Calling getBookStoreName method first time.
		System.out.println(bookAppB.getBookStore().getBookStoreName());
		//Calling getBookStoreName method second time.
		//This time, method will not execute because result is cached with "bookstore"
		System.out.println(bookAppB.getBookStore().getBookStoreName());
		ctx.close();
	}
}
