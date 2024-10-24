package model;

import java.util.Date;

public class SalariedEmployee extends Employee {
	private double commisstionRate;
	private double grossSales;
	private double basicSalary;

	public SalariedEmployee() {
	}

	public SalariedEmployee(double commisstionRate, double grossSales, double basicSalary) {
		this.commisstionRate = commisstionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}

	public SalariedEmployee(String ssn, String firstName, String lastName, Date birthDate, String phone, String email) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
	}

	public SalariedEmployee(String ssn, String firstName, String lastName, Date birthDate, String phone, String email,
			double commisstionRate, double grossSales, double basicSalary) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		// TODO Auto-generated constructor stub
		this.commisstionRate = commisstionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}

	public double getCommisstionRate() {
		return commisstionRate;
	}

	public void setCommisstionRate(double commisstionRate) {
		this.commisstionRate = commisstionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return "SalariedEmployee [commisstionRate=" + commisstionRate + ", grossSales=" + grossSales + ", basicSalary="
				+ basicSalary + "]";
	}

	@Override
	public String displayWriteFile() {
		// TODO Auto-generated method stub
		return commisstionRate + "," + grossSales + "," + basicSalary + "," + null + "," + null;
	}
}
