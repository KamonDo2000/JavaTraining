package model;

public abstract class Person {

	private int type;
	private String passengerID;
	private String name;
	private String birthDate;
	private String address;
	private String phone;
	private String testDate;
	private String flightDate;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	Person() {
	}

	public String showInfo() {
		return "Person [passengerID=" + passengerID + ", name=" + name + ", birthDate=" + birthDate + ", address="
				+ address + ", phone=" + phone + ", testDate=" + testDate + ", flightDate=" + flightDate + infoDetail()
				+ "]";
	}

	public abstract String infoDetail();

}
