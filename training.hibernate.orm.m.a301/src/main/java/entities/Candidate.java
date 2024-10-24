package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private long id;

	@NotNull
	@Column(name = "full_name", length = 255)
	private String fullName;

	@NotNull
	@Column(name = "date_of_birth", columnDefinition = "DATE")
	private String dateOfBirth;

	@Min(value = 0, message = "Invalid number of articles. Minimum should be 0.")
	@Max(value = 1, message = "Invalid number of articles. Maximum allowed is 1.")
	private int gender;

	@NotNull
	@Column(name = "graduation_year", columnDefinition = "DATE")
	private String graduationYear;

	@NotNull
//    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain exactly 10 digits")
	@Column(length = 255)
	private String phone;

	@NotNull
	@Email
	@Column(length = 255)
	private String email;

	@Column(length = 255)
	private String skill;

	@Column(name = "foreign_language", length = 255)
	private String foreignLanguage;

	@Min(value = 1, message = "Invalid number of articles. Minimum should be 1.")
	@Max(value = 7, message = "Invalid number of articles. Maximum allowed is 7.")
	private int level;

	@Column(length = 255)
	private String cv;

	@Column(name = "allocation_status")
	private int allocationStatus;

	@Column(length = 1000)
	private String remark;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	private Set<EntryTest> entryTests;

	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
	private Set<Interview> interviews;

	public Candidate() {
	}

	public Candidate(String fullName, String dateOfBirth, int gender, String graduationYear, String phone, String email,
			String skill, String foreignLanguage, int level, String cv, int allocationStatus, String remark) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.cv = cv;
		this.allocationStatus = allocationStatus;
		this.remark = remark;
	}

	public Candidate(String fullName, String dateOfBirth, int gender, String graduationYear, String phone, String email,
			String skill, String foreignLanguage, int level, String cv, int allocationStatus, String remark,
			Set<EntryTest> entryTests, Set<Interview> interviews) {
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.graduationYear = graduationYear;
		this.phone = phone;
		this.email = email;
		this.skill = skill;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
		this.cv = cv;
		this.allocationStatus = allocationStatus;
		this.remark = remark;
		this.entryTests = entryTests;
		this.interviews = interviews;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public int getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(int allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<EntryTest> getEntryTests() {
		return entryTests;
	}

	public void setEntryTests(Set<EntryTest> entryTests) {
		this.entryTests = entryTests;
	}

	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	@Override
	public String toString() {
		String gen;
		if (gender == 0) {
			gen = "female";
		} else {
			gen = "male";
		}

		return id + " || " + fullName + " || " + dateOfBirth + " || " + gen + " || graduation: " + graduationYear
				+ " || " + phone + " || " + email + " || " + skill + " || Language:  " + foreignLanguage + " || level: "
				+ level + " || cv: " + cv + " || remark: " + remark;
	}
}
