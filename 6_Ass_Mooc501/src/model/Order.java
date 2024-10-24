package model;

import java.time.LocalDate;

public class Order {
	String number;
	LocalDate date;

	public Order() {
		super();
	}

	public Order(String number, LocalDate date) {
		super();
		this.number = number;
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
