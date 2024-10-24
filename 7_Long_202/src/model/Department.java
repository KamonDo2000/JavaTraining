package model;

import java.util.List;

public class Department {
	private String departmentName;
	private List<Employee> listEmployees;

	public Department() {
	}

	/**
	 * @param departmentName
	 */
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department(String departmentName, List<Employee> listEmployees) {
		this.departmentName = departmentName;
		this.listEmployees = listEmployees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}

	@Override
	public String toString() {
		return "Department [department name=" + departmentName + ", number of employees=" + listEmployees.size() + "]";
	}
	
	public String writeFile() {
		return departmentName;
	}

}
