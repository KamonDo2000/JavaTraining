package model;

import java.time.LocalDate;

public abstract class Publication {

	private String publisher;
	private int publivationYear;
	private LocalDate publicationDate;

	public abstract void display();

	protected Publication() {
		super();
	}

	protected Publication(String publisher, int publivationYear, LocalDate publicationDate) {
		this.publisher = publisher;
		this.publivationYear = publivationYear;
		this.publicationDate = publicationDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublivationYear() {
		return publivationYear;
	}

	public void setPublivationYear(int publivationYear) {
		this.publivationYear = publivationYear;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

}
