package model;

import java.util.Date;

public class HourlyEmployee extends Employee {

	private double rate;
	private double workingHours;

	public HourlyEmployee() {
	}

	public HourlyEmployee(double rate, double workingHours) {
		this.rate = rate;
		this.workingHours = workingHours;
	}

	public HourlyEmployee(String ssn, String firstName, String lastName, Date birthDate, String phone, String email) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
	}

	public HourlyEmployee(String ssn, String firstName, String lastName, Date birthDate, String phone, String email,
			double rate, double workingHours) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
		this.rate = rate;
		this.workingHours = workingHours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return "HourlyEmployee [rate=" + rate + ", workingHours=" + workingHours + "]";
	}

	@Override
	public String displayWriteFile() {
		// TODO Auto-generated method stub
		return null + "," + null + "," + null + "," + rate + "," + workingHours;
	}

}
