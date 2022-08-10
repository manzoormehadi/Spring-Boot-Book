package com.bezkoder.spring.jpa.h2.repository;

import com.bezkoder.spring.jpa.h2.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {

	List<BookPublisher> findBypublisherNameContaining(String publisherName);

	void deleteBypublisherId(long publisherId);

	Optional<BookPublisher> findByPublisherId(long publisherId);
}
