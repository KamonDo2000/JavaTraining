package model;

import java.time.LocalDate;

public class Book {

	private int id;
	private String title;
	private String author;
	private LocalDate dateEXP;
	private float price;
	private int quantity;
	private int status;

	public Book() {
	}

	public Book(int id, String title, String author, LocalDate dateEXP, float price, int quantity, int status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.dateEXP = dateEXP;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getDateEXP() {
		return dateEXP;
	}

	public void setDateEXP(LocalDate dateEXP) {
		this.dateEXP = dateEXP;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
