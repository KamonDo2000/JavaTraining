package model;

public class Student extends Person {

	String studentId;
	double theory;
	double practice;

	@Override
	void purchaseParkingPass() {
		//td
		
	}

	public double calculateFinalMark() {
		return (theory + practice) / 2;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public double getTheory() {
		return theory;
	}

	public void setTheory(double theory) {
		this.theory = theory;
	}

	public double getPractice() {
		return practice;
	}

	public void setPractice(double practice) {
		this.practice = practice;
	}

}
