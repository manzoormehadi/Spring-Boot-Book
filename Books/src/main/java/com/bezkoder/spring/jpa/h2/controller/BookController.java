package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.Book;
import com.bezkoder.spring.jpa.h2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book student) {
		return bookService.saveBook(student);
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/book")
	public List<Book> getAllBook(){
	 	return bookService.getAllBook();
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		return bookService.deleteBook(id);
	}

}
