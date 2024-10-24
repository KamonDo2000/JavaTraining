package model;

public class Children extends Person {

	private String school;
	private String grade;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Children(String school, String grade) {
		super();
		this.school = school;
		this.grade = grade;
	}

	public Children() {
		super();
	}

	@Override
	public String infoDetail() {
		return "school=" + school + ", grade=" + grade ;
	}

}
