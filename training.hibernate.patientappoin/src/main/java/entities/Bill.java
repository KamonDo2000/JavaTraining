package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Bill {
	@Id

	@Column(name = "Bill_number", length = 7, unique = true, nullable = false)
	private int billNumber;

	@Column(name = "Bill_date")
	private LocalDate billDate;

	@Column(name = "Bill_status")
	private String billStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "app_id")
	private Appointment appointment;

	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Payment> payments = new ArrayList<>();

	public Bill() {
		super();
	}

	public Bill(int bill_number, LocalDate bill_date, String bill_status, Appointment appointment) {
		super();
		this.billNumber = bill_number;
		this.billDate = bill_date;
		this.billStatus = bill_status;
		this.appointment = appointment;
	}

	public Bill(int bill_number, LocalDate bill_date, String bill_status) {
		super();
		this.billNumber = bill_number;
		this.billDate = bill_date;
		this.billStatus = bill_status;
	}

	/**
	 * @return the bill_number
	 */
	public int getBill_number() {
		return billNumber;
	}

	/**
	 * @param bill_number the bill_number to set
	 */
	public void setBill_number(int bill_number) {
		this.billNumber = bill_number;
	}

	/**
	 * @return the bill_date
	 */
	public LocalDate getBill_date() {
		return billDate;
	}

	/**
	 * @param bill_date the bill_date to set
	 */
	public void setBill_date(LocalDate bill_date) {
		this.billDate = bill_date;
	}

	/**
	 * @return the bill_status
	 */
	public String getBill_status() {
		return billStatus;
	}

	/**
	 * @param bill_status the bill_status to set
	 */
	public void setBill_status(String bill_status) {
		this.billStatus = bill_status;
	}

	/**
	 * @return the appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}

	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	/**
	 * @return the payments
	 */
	public List<Payment> getPayments() {
		return payments;
	}

	/**
	 * @param payments the payments to set
	 */
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return billNumber + " || bill Date: " + billDate + " || bill Status: " + billStatus;
	}

}
