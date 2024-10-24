package model;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Candidate {

	int expInYear;
	String proSkill;

	public Experience() {
		super("0");
	}

	public Experience(String candidateID, String fullName, LocalDate birthDay, String phone, String email,
			List<Certificate> listCertificate, int expInYear, String proSkill) {
		super("0");
		this.expInYear = expInYear;
		this.proSkill = proSkill;

		this.setCandidateID(candidateID);
		this.setFullName(fullName);
		this.setBirthDay(birthDay);
		this.setPhone(phone);
		this.setEmail(email);
		this.setListCertificate(listCertificate);
	}

	@Override
	protected void showMe() {
		System.out.print(" || " + this.expInYear);
		System.out.print(" || " + this.proSkill);
	}

	/**
	 * @param expInYear the expInYear to set
	 */
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	/**
	 * @param proSkill the proSkill to set
	 */
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	/**
	 * @return the expInYear
	 */
	public int getExpInYear() {
		return expInYear;
	}

	/**
	 * @return the proSkill
	 */
	public String getProSkill() {
		return proSkill;
	}

}
