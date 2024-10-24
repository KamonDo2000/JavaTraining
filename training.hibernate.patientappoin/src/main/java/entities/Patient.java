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
public class Patient {
	@Id
	@Column(name = "Pat_ID", length = 10, nullable = false, unique = true)
	private String patId;

	@Column(name = "Pat_firstname")
	private String patFirstName;

	@Column(name = "Pat_lastname")
	private String patLastName;

	@Column(name = "Pat_address")
	private String patAddress;

	@Column(name = "Pat_city")
	private String patCity;

	@Column(name = "Pat_state")
	private String patState;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true) // Thuộc tính mà Doctor tham chiếu
	private List<Appointment> appointments;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true) // Thuộc tính mà Doctor tham chiếu
	private List<Payment> payment;

	public Patient() {
		super();
	}

	public Patient(String pat_id, String pat_first_name, String pat_last_name, String pat_address, String pat_city,
			String pat_sate, List<Appointment> appointments, List<Payment> payment) {
		super();
		this.patId = pat_id;
		this.patFirstName = pat_first_name;
		this.patLastName = pat_last_name;
		this.patAddress = pat_address;
		this.patCity = pat_city;
		this.patState = pat_sate;
		this.appointments = appointments;
		this.payment = payment;
	}

	public Patient(String pat_id, String pat_first_name, String pat_last_name, String pat_address, String pat_city,
			String pat_sate) {
		super();
		this.patId = pat_id;
		this.patFirstName = pat_first_name;
		this.patLastName = pat_last_name;
		this.patAddress = pat_address;
		this.patCity = pat_city;
		this.patState = pat_sate;
	}

	/**
	 * @return the pat_id
	 */
	public String getPat_id() {
		return patId;
	}

	/**
	 * @param pat_id the pat_id to set
	 */
	public void setPat_id(String pat_id) {
		this.patId = pat_id;
	}

	/**
	 * @return the pat_first_name
	 */
	public String getPat_first_name() {
		return patFirstName;
	}

	/**
	 * @param pat_first_name the pat_first_name to set
	 */
	public void setPat_first_name(String pat_first_name) {
		this.patFirstName = pat_first_name;
	}

	/**
	 * @return the pat_last_name
	 */
	public String getPat_last_name() {
		return patLastName;
	}

	/**
	 * @param pat_last_name the pat_last_name to set
	 */
	public void setPat_last_name(String pat_last_name) {
		this.patLastName = pat_last_name;
	}

	/**
	 * @return the pat_address
	 */
	public String getPat_address() {
		return patAddress;
	}

	/**
	 * @param pat_address the pat_address to set
	 */
	public void setPat_address(String pat_address) {
		this.patAddress = pat_address;
	}

	/**
	 * @return the pat_city
	 */
	public String getPat_city() {
		return patCity;
	}

	/**
	 * @param pat_city the pat_city to set
	 */
	public void setPat_city(String pat_city) {
		this.patCity = pat_city;
	}

	/**
	 * @return the pat_sate
	 */
	public String getPat_sate() {
		return patState;
	}

	/**
	 * @param pat_sate the pat_sate to set
	 */
	public void setPat_sate(String pat_sate) {
		this.patState = pat_sate;
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

	/**
	 * @return the payment
	 */
	public List<Payment> getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return patId + " || pat First Name: " + patFirstName + " || pat Last Name: " + patLastName + " || pat Address: "
				+ patAddress + " || pat City: " + patCity + " || pat State: " + patState;
	}

}
