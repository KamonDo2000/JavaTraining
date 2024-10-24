package model;

import java.util.List;

public class Customer {

	String name;
	String phoneNumber;
	String address;
	List<Order> listOrder;

	public Customer() {
		super();
	}

	public Customer(String name, String phoneNumber, String address, List<Order> listOrder) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.listOrder = listOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getListCus() {
		StringBuilder sb = new StringBuilder();
		for (Order o : listOrder) {
			sb.append("[ number: " + o.number.toString());
			sb.append(", Date: " + o.date.toString() + " ],  ");
		}
		return sb.toString();
	}

	public void setListCus(List<Order> listOrder) {
		this.listOrder = listOrder;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Order o : listOrder) {
			sb.append("[ number: " + o.number.toString());
			sb.append(", Date: " + o.date.toString() + " ],  ");
		}

		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", Order="
				+ sb.toString() + "]";
	}

}
