package entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment") // Đặt tên bảng nếu cần thiết
public class Appointment {
	@Id
	@Column(name = "app_id")
	private String appId;

	@Column(name = "app_date", nullable = false)
	private LocalDate appDate;

	@Column(name = "app_time")
	private LocalTime appTime;

	@Column(name = "app_duration")
	private String appDuration;

	@Column(name = "app_reason")
	private String appReason;

	@ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY chỉ khi cần thiết
	@JoinColumn(name = "Doc_Number")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY chỉ khi cần thiết
	@JoinColumn(name = "Pat_ID")
	private Patient patient;

	// OneToOne với class Bill
	@OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Bill bill;

	public Appointment() {
		super();
	}

	public Appointment(String app_id, LocalDate app_date, LocalTime app_time, String app_duration, String app_reason,
			Doctor doctor, Patient patient) {
		super();
		this.appId = app_id;
		this.appDate = app_date;
		this.appTime = app_time;
		this.appDuration = app_duration;
		this.appReason = app_reason;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Appointment(String app_id, LocalDate app_date, LocalTime app_time, String app_duration, String app_reason) {
		super();
		this.appId = app_id;
		this.appDate = app_date;
		this.appTime = app_time;
		this.appDuration = app_duration;
		this.appReason = app_reason;
	}

	/**
	 * @return the app_id
	 */
	public String getApp_id() {
		return appId;
	}

	/**
	 * @param app_id the app_id to set
	 */
	public void setApp_id(String app_id) {
		this.appId = app_id;
	}

	/**
	 * @return the app_date
	 */
	public LocalDate getApp_date() {
		return appDate;
	}

	/**
	 * @param app_date the app_date to set
	 */
	public void setApp_date(LocalDate app_date) {
		this.appDate = app_date;
	}

	/**
	 * @return the app_time
	 */
	public LocalTime getApp_time() {
		return appTime;
	}

	/**
	 * @param app_time the app_time to set
	 */
	public void setApp_time(LocalTime app_time) {
		this.appTime = app_time;
	}

	/**
	 * @return the app_duration
	 */
	public String getApp_duration() {
		return appDuration;
	}

	/**
	 * @param app_duration the app_duration to set
	 */
	public void setApp_duration(String app_duration) {
		this.appDuration = app_duration;
	}

	/**
	 * @return the app_reason
	 */
	public String getApp_reason() {
		return appReason;
	}

	/**
	 * @param app_reason the app_reason to set
	 */
	public void setApp_reason(String app_reason) {
		this.appReason = app_reason;
	}

	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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

	@Override
	public String toString() {
		return appId + " || app_date: " + appDate + " || app_time: " + appTime + " || app_duration: " + appDuration
				+ " || app_reason: " + appReason;
//				+ " || doctor ID: " + doctor.getDoc_number() + " || patient ID: "
//				+ patient.getPat_id() + " || Bill ID: " + bill.getBill_number();
	}

}
