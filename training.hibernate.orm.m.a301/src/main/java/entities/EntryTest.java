package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class EntryTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private long id;

	private String time;

	@Column(columnDefinition = "DATE")
	private String date;

	@Column(name = "language_evaluator")
	private String languageEvaluator;

	@Min(value = 0, message = "Invalid number of articles. Minimum should be 0.")
	@Max(value = 10, message = "Invalid number of articles. Maximum allowed is 10.")
	@Column(name = "language_result", columnDefinition = "decimal(4,2)")
	private double languageResult;

	@Column(name = "technical_evaluator")
	private String technicalEvaluator;

	@Min(value = 0, message = "Invalid number of articles. Minimum should be 0.")
	@Max(value = 10, message = "Invalid number of articles. Maximum allowed is 10.")
	@Column(name = "technical_result", columnDefinition = "decimal(4,2)")
	private double technicalResult;

	@Pattern(regexp = "^(pass|fail)$", message = "Value must be 'pass' or 'fail'")
	private String result;

	@Column(columnDefinition = "VARCHAR(1000)")
	private String remark;

	@Column(name = "entryTest_skill")
	private String entryTestSkill;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
	Candidate candidate;

	public EntryTest() {
	}

	public EntryTest(String time, String date, String languageEvaluator, double languageResult,
			String technicalEvaluator, double technicalResult, String result, String remark, String entryTestSkill,
			Candidate candidate) {
		this.time = time;
		this.date = date;
		this.languageEvaluator = languageEvaluator;
		this.languageResult = languageResult;
		this.technicalEvaluator = technicalEvaluator;
		this.technicalResult = technicalResult;
		this.result = result;
		this.remark = remark;
		this.entryTestSkill = entryTestSkill;
		this.candidate = candidate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLanguageEvaluator() {
		return languageEvaluator;
	}

	public void setLanguageEvaluator(String languageEvaluator) {
		this.languageEvaluator = languageEvaluator;
	}

	public double getLanguageResult() {
		return languageResult;
	}

	public void setLanguageResult(double languageResult) {
		this.languageResult = languageResult;
	}

	public String getTechnicalEvaluator() {
		return technicalEvaluator;
	}

	public void setTechnicalEvaluator(String technicalEvaluator) {
		this.technicalEvaluator = technicalEvaluator;
	}

	public double getTechnicalResult() {
		return technicalResult;
	}

	public void setTechnicalResult(double technicalResult) {
		this.technicalResult = technicalResult;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEntryTestSkill() {
		return entryTestSkill;
	}

	public void setEntryTestSkill(String entryTestSkill) {
		this.entryTestSkill = entryTestSkill;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "EntryTest{" + "id=" + id + ", time='" + time + '\'' + ", date='" + date + '\'' + ", languageEvaluator='"
				+ languageEvaluator + '\'' + ", languageResult=" + languageResult + ", technicalEvaluator='"
				+ technicalEvaluator + '\'' + ", technicalResult=" + technicalResult + ", result='" + result + '\''
				+ ", remark='" + remark + '\'' + ", entryTestSkill='" + entryTestSkill + '\'' + ", candidate="
				+ candidate + '}';
	}
}
