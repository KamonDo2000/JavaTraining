package model;

public class Course {
	String courseCode;
	String courseName;
	double duration;
	String status;
	String flag;

	public Course() {
		super();
	}

	public Course(String courseCode, String courseName, double duration, String status, String flag) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.duration = duration;
		this.status = status;
		this.flag = flag;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Course courseCode=" + courseCode + ", courseName=" + courseName + ", duration=" + duration + ", status="
				+ status + ", flag=" + flag + "  ";
	}

}
