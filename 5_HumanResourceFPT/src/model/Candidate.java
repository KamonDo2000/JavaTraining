package model;

import java.time.LocalDate;
import java.util.List;

import view.IOLocalDate;

public abstract class Candidate {

	private static int canidateCount = 0;
	private String candidateType;

	private String candidateID;

	private String fullName;
	private LocalDate birthDay;
	private String phone;
	private String email;

	private List<Certificate> listCertificate;

	protected Candidate(String candidateType) {
		canidateCount++;
		this.candidateType = candidateType;
	}
	
	/**
	 * @return the canidateCount
	 */
	public int getCanidateCount() {
		return canidateCount;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param candidateID the candidateID to set
	 */
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	/**
	 * @return the candidateID
	 */
	public String getCandidateID() {
		return candidateID;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return the birthDay
	 */
	public LocalDate getBirthDay() {
		return birthDay;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the listCertificate
	 */
	public List<Certificate> getListCertificate() {
		return listCertificate;
	}

	/**
	 * @param listCertificate the listCertificate to set
	 */
	public void setListCertificate(List<Certificate> listCertificate) {
		this.listCertificate = listCertificate;
	}

	/**
	 * @return the candidateType
	 */
	public String getCandidateType() {
		return candidateType;
	}

	protected abstract void showMe();

	public void showInfo() {
		System.out.print(canidateCount);
		System.out.print(" -- " + this.candidateID);
		System.out.print(" || " + this.fullName);
		System.out.print(" || " + IOLocalDate.ouput(this.birthDay));
		System.out.print(" || " + this.phone);
		System.out.print(" || " + this.email);
		System.out.print(" || " + this.candidateType);
		showMe();
		showCertificate();
		System.out.println("\n\n================================================");
	}

	private void showCertificate() {
		if (this.listCertificate == null) {
			System.out.print("\n\t\t\t");
			System.out.print("have not Certificate!!");
			System.out.println();
			return;
		}
		for (Certificate obj : this.listCertificate) {
			System.out.println();
			System.out.print("\n\t\t\t");
			System.out.print("---" + obj.getCertificatedID());
			System.out.print(" || " + obj.getCertificateName());
			System.out.print(" || " + obj.getCertificateRank());
			System.out.print(" || " + IOLocalDate.ouput(obj.getCertificatedDate()));
		}
	}

}
