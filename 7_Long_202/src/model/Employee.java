package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {
	private String ssn;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String phone;
	private String email;

	public Employee() {
	}

	public Employee(String ssn, String firstName, String lastName, Date birthDate, String phone, String email) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", phone=" + phone + ", email=" + email + display() + "]";
	}

	public String writeFile() {
		String dateString = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
		return ssn + "," + firstName + "," + lastName + "," + dateString + "," + phone + "," + email + "," + displayWriteFile();
	}

	public abstract String display();
	public abstract String displayWriteFile();
}
