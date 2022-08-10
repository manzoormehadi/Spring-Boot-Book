package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.BookPublisher;
import com.bezkoder.spring.jpa.h2.repository.BookPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class publisherNameController {

	@Autowired
	BookPublisherRepository publisherRepository;

	@GetMapping("/publisher")
	public ResponseEntity<List<BookPublisher>> getAllPublishers(@RequestParam(required = false) String publisherName) {
		try {
			List<BookPublisher> publisher = new ArrayList<BookPublisher>();

			if (publisherName == null)
				publisherRepository.findAll().forEach(publisher::add);
			else
				publisherRepository.findBypublisherNameContaining(publisherName).forEach(publisher::add);

			if (publisher.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(publisher, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/publisher/{publisherId}")
	public ResponseEntity<BookPublisher> getPublisherById(@PathVariable("publisherId") long publisherId) {
		Optional<BookPublisher> publisherData = publisherRepository.findById(publisherId);

		if (publisherData.isPresent()) {
			return new ResponseEntity<>(publisherData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/publisher")
	public ResponseEntity<BookPublisher> createTutorial(@RequestBody BookPublisher publisher) {
		try {
			BookPublisher _publisher = publisherRepository
					.save(new BookPublisher(publisher.getPublisherName(), publisher.getPublisherAddress(), false));
			return new ResponseEntity<>(_publisher, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/publisher/{publisherId}")
	public ResponseEntity<BookPublisher> updateTutorial(@PathVariable("publisherId") long publisherId, @RequestBody BookPublisher tutorial) {
		Optional<BookPublisher> publisherData = publisherRepository.findByPublisherId(publisherId);

		if (publisherData.isPresent()) {
			BookPublisher _publisher = publisherData.get();
			_publisher.setPublisherName(tutorial.getPublisherName());
			_publisher.setPublisherAddress(tutorial.getPublisherAddress());
			return new ResponseEntity<>(publisherRepository.save(_publisher), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	

}
