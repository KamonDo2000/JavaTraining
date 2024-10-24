package model;

public class Teacher extends Person {

	double basicSalary;
	double subSidy;
	
	@Override
	void purchaseParkingPass() {
	}

	public double caculateSalary() {
		return basicSalary + subSidy;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getSubSidy() {
		return subSidy;
	}

	public void setSubSidy(double subSidy) {
		this.subSidy = subSidy;
	}

}
