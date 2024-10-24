package model;

import java.time.LocalDate;
import java.util.Set;

public class Book extends Publication {

	private String isbn;
	private Set<String> author;
	private String publicationPlace;

	@Override
	public void display() {
		System.out.print("author: ");
		for (String aut : author) {
			System.out.print(aut + ",\t");
		}
		System.out.println("\nIsbn: " + this.isbn);
		System.out.println("Publication Place: " + this.publicationPlace);
		System.out.println("publisher: " + this.getPublisher());
		System.out.println("publivation Year: " + this.getPublivationYear());
		System.out.println("publication Date: " + this.getPublicationDate().toString());
		System.out.println("\n");
	}

	public Book() {
		super();
	}

	public Book(String isbn, Set<String> author, String publicationPlace, String publisher, int publivationYear,
			LocalDate publicationDate) {
		super(publisher, publivationYear, publicationDate);
		this.isbn = isbn;
		this.publicationPlace = publicationPlace;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(Set<String> author) {
		this.author = author;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

	@Override
	public String toString() {
		StringBuilder autList = new StringBuilder();
		for (String aut : author) {
			autList.append(aut + " || ");
		}
		return "Book [isbn=" + isbn + ", author=" + autList + ", publicationPlace=" + publicationPlace + ", Publisher="
				+ getPublisher() + ", PublivationYear=" + getPublivationYear() + ", PublicationDate="
				+ getPublicationDate() + "]";
	}

}
