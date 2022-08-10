package com.bezkoder.spring.jpa.h2.model;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class BookPublisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long publisherId;

	@Column(name = "publisherName")
	private String publisherName;

	@Column(name = "publisherAddress")
	private String publisherAddress;

	@Column(name = "published")
	private boolean published;

	public BookPublisher() {

	}

	public BookPublisher(String title, String description, boolean published) {
		this.publisherName = title;
		this.publisherAddress = description;
		this.published = published;
	}

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	

	@Override
	public String toString() {
		return "BookPublisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherAddress="
				+ publisherAddress + "]";
	}

	

}
