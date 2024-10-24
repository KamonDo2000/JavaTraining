package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Doctor {
	@Id
	@Column(name = "doc_number", length = 10, nullable = false, unique = true)
	private String docNumber;

	@Column(name = "doc_firstname", length = 255)
	private String docFirstName;

	@Column(name = "doc_lastname", length = 255)
	private String docLastName;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true) // Thuộc tính mà Doctor tham chiếu
																						// tới
	private List<Appointment> appointments;

	public Doctor() {
		super();
	}

	public Doctor(String doc_number, String doc_firstname, String doc_lastname) {
		super();
		this.docNumber = doc_number;
		this.docFirstName = doc_firstname;
		this.docLastName = doc_lastname;
	}

	public Doctor(String doc_number, String doc_firstname, String doc_lastname, List<Appointment> appointments) {
		super();
		this.docNumber = doc_number;
		this.docFirstName = doc_firstname;
		this.docLastName = doc_lastname;
		this.appointments = appointments;
	}

	/**
	 * @return the doc_number
	 */
	public String getDoc_number() {
		return docNumber;
	}

	/**
	 * @param doc_number the doc_number to set
	 */
	public void setDoc_number(String doc_number) {
		this.docNumber = doc_number;
	}

	/**
	 * @return the doc_firstname
	 */
	public String getDoc_firstname() {
		return docFirstName;
	}

	/**
	 * @param doc_firstname the doc_firstname to set
	 */
	public void setDoc_firstname(String doc_firstname) {
		this.docFirstName = doc_firstname;
	}

	/**
	 * @return the doc_lastname
	 */
	public String getDoc_lastname() {
		return docLastName;
	}

	/**
	 * @param doc_lastname the doc_lastname to set
	 */
	public void setDoc_lastname(String doc_lastname) {
		this.docLastName = doc_lastname;
	}

	/**
	 * @return the appointments
	 */
	public List<Appointment> getAppointments() {
		return appointments;
	}

	/**
	 * @param appointments the appointments to set
	 */
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return docNumber + " || doc Firstname: " + docFirstName + " || doc Lastname: " + docLastName;
	}

}
