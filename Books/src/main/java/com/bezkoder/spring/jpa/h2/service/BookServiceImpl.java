package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.model.Book;
import com.bezkoder.spring.jpa.h2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired //inject repository dependency
	BookRepository studentRepository;
	
	@Override
	public Book saveBook(Book book) {
		return studentRepository.save(book); //save student
	}
	
	@Override
	public Book getBookById(Long id) {
		Optional<Book> book = studentRepository.findById(id);
		if(book.isPresent()) return book.get();
		return null;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> books = new ArrayList<Book>(); //create list of students variable
		studentRepository.findAll().forEach(student ->books.add(student)); // keep each student in students list
		return books;
	}
	
	@Override
	public Book updateBook(Long id, Book book) {
		Optional<Book> bookById = studentRepository.findById(id);
		
		if(bookById.isPresent()) { 
			Book updatedBook = bookById.get();
		
			updatedBook.setId(book.getId());
			updatedBook.setName(book.getName());
			updatedBook.setPrice(book.getPrice());
			updatedBook.setAuthor(book.getAuthor());
			
			return studentRepository.save(updatedBook);
		}
		
		return null;
	}

	@Override
	public String deleteBook(Long id) {
		studentRepository.deleteById(id); //delete student by id
		return "id" + id + "is deleted successfully"; 
	}
}
