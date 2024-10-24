package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Payment {
	@Id

	@Column(name = "Pay_recilptnum", length = 10, unique = true, nullable = false)
	private String payReceiptnum;

	@Column(name = "Pay_date")
	private LocalDate payDate;

	@Column(name = "Pay_method")
	private String payMethod;

	@Column(name = "Pay_amount")
	private String payAmount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Pat_ID")
	private Patient patient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Bill_number")
	private Bill bill;

	public Payment() {
		super();
	}

	public Payment(String pay_receiptnum, LocalDate pay_date, String pay_method, String pay_amount, Patient patient,
			Bill bill) {
		super();
		this.payReceiptnum = pay_receiptnum;
		this.payDate = pay_date;
		this.payMethod = pay_method;
		this.payAmount = pay_amount;
		this.patient = patient;
		this.bill = bill;
	}

	public Payment(String pay_receiptnum, LocalDate pay_date, String pay_method, String pay_amount) {
		super();
		this.payReceiptnum = pay_receiptnum;
		this.payDate = pay_date;
		this.payMethod = pay_method;
		this.payAmount = pay_amount;
	}

	/**
	 * @return the pay_receiptnum
	 */
	public String getPay_receiptnum() {
		return payReceiptnum;
	}

	/**
	 * @param pay_receiptnum the pay_receiptnum to set
	 */
	public void setPay_receiptnum(String pay_receiptnum) {
		this.payReceiptnum = pay_receiptnum;
	}

	/**
	 * @return the pay_date
	 */
	public LocalDate getPay_date() {
		return payDate;
	}

	/**
	 * @param localDate the pay_date to set
	 */
	public void setPay_date(LocalDate localDate) {
		this.payDate = localDate;
	}

	/**
	 * @return the pay_method
	 */
	public String getPay_method() {
		return payMethod;
	}

	/**
	 * @param pay_method the pay_method to set
	 */
	public void setPay_method(String pay_method) {
		this.payMethod = pay_method;
	}

	/**
	 * @return the pay_amount
	 */
	public String getPay_amount() {
		return payAmount;
	}

	/**
	 * @param pay_amount the pay_amount to set
	 */
	public void setPay_amount(String pay_amount) {
		this.payAmount = pay_amount;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return payReceiptnum + " || pay Date: " + payDate + " || pay Method: " + payMethod + " || pay Amount: "
				+ payAmount + " || Bill number: " + bill.getBill_number() + " || patient number: "
				+ patient.getPat_id();
	}

}
