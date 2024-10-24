package entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Interview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "interview_id")
	private long id;

	private String time;

	private LocalDate date;

	private String interviewer;

	private String comments;

	@Column(name = "interview_result")
	private String interviewResult;

	private String remark;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_id", referencedColumnName = "candidate_id")
	Candidate candidate;

	public Interview() {
	}

	public Interview(String time, LocalDate date, String interviewer, String comments, String interviewResult,
			String remark, Candidate candidate) {
		this.time = time;
		this.date = date;
		this.interviewer = interviewer;
		this.comments = comments;
		this.interviewResult = interviewResult;
		this.remark = remark;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getInterviewResult() {
		return interviewResult;
	}

	public void setInterviewResult(String interviewResult) {
		this.interviewResult = interviewResult;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return id + " || time: " + time + " || date: " + date + " || interviewer: " + interviewer + " || comments: "
				+ comments + " || interviewResult: " + interviewResult + " || remark: " + remark + " || candidate: "
				+ candidate.toString();
	}
}
