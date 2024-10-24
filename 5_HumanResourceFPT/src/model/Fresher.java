package model;

import java.time.LocalDate;
import java.util.List;

import view.IOLocalDate;

public class Fresher extends Candidate {

	LocalDate graduationDate;
	String graduationRank;
	String education;

	public Fresher() {
		super("1");

	}

	public Fresher(String candidateID, String fullName, LocalDate birthDay, String phone, String email,
			List<Certificate> listCertificate, LocalDate graduationDate, String graduationRank, String education) {
		super("1");
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;

		this.setCandidateID(candidateID);
		this.setFullName(fullName);
		this.setBirthDay(birthDay);
		this.setPhone(phone);
		this.setEmail(email);
		this.setListCertificate(listCertificate);
	}

	@Override
	protected void showMe() {
		System.out.print(" || " + IOLocalDate.ouput(this.graduationDate));
		System.out.print(" || " + this.graduationRank);
		System.out.print(" || " + this.education);
	}

	/**
	 * @param graduationDate the graduationDate to set
	 */
	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	/**
	 * @param graduationRank the graduationRank to set
	 */
	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the graduationDate
	 */
	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	/**
	 * @return the graduationRank
	 */
	public String getGraduationRank() {
		return graduationRank;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

}
