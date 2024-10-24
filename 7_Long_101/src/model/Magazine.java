package model;

import java.time.LocalDate;

public class Magazine extends Publication {

	private String author;
	private int volumn;
	private int edition;

	@Override
	public void display() {
		System.out.println("Author: " + this.author);
		System.out.println("Volumn: " + this.volumn);
		System.out.println("Edition: " + this.edition);
		System.out.println("publisher: " + this.getPublisher());
		System.out.println("publivationYear: " + this.getPublivationYear());
		System.out.println("publicationDate: " + this.getPublicationDate().toString());
		System.out.println("\n");
	}

	public Magazine() {
		super();
	}

	public Magazine(String author, int volumn, int edition, String publisher, int publivationYear,
			LocalDate publicationDate) {
		super(publisher, publivationYear, publicationDate);
		this.author = author;
		this.volumn = volumn;
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Magazine [author=" + author + ", volumn=" + volumn + ", edition=" + edition + ", Publisher= "
				+ getPublisher() + ", PublivationYear= " + getPublivationYear() + ", PublicationDate= "
				+ getPublicationDate() + "]";
	}

}
