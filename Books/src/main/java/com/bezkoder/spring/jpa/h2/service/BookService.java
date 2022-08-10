package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.model.Book;

import java.util.List;


public interface BookService {
	
	List<Book> getAllBook();
	Book getBookById(Long id);
	Book saveBook(Book book);
	Book updateBook(Long id, Book book);
	String deleteBook(Long id);
	

}
