package com.concretepage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class CacheDemoA {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigA.class);
		ctx.refresh();
		BookAppA bookAppA = ctx.getBean(BookAppA.class);
		//Calling getBook method first time.
		System.out.println(bookAppA.getBook().getBookName());
		//Calling getBook method second time.
		//This time, method will not execute because result is cached with "mycache"
		System.out.println(bookAppA.getBook().getBookName());
		ctx.close();
	}
}
