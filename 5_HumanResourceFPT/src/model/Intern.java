package model;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Candidate {

	String majors;
	int semester;
	String universityName;

	public Intern() {
		super("2");
	}

	public Intern(String candidateID, String fullName, LocalDate birthDay, String phone, String email,
			List<Certificate> listCertificate, String majors, int semester, String universityName) {
		super("2");
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;

		this.setCandidateID(candidateID);
		this.setFullName(fullName);
		this.setBirthDay(birthDay);
		this.setPhone(phone);
		this.setEmail(email);
		this.setListCertificate(listCertificate);
	}

	/**
	 * @param majors the majors to set
	 */
	public void setMajors(String majors) {
		this.majors = majors;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

	/**
	 * @param universityName the universityName to set
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	/**
	 * @return the majors
	 */
	public String getMajors() {
		return majors;
	}

	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @return the universityName
	 */
	public String getUniversityName() {
		return universityName;
	}

	@Override
	protected void showMe() {
		System.out.print(" || " + this.majors);
		System.out.print(" || " + this.semester);
		System.out.print(" || " + this.universityName);
	}

}
