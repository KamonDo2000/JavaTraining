package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.Department;
import model.Employee;
import utils.CheckValidDate;

public class DepartmentService {
	static CheckValidDate checkValidDate = new CheckValidDate();
	Scanner scanner = new Scanner(System.in);
	
	public Department createDepartment() {
		Department department = new Department();
		
		System.out.println("------ENTER EMPLOYEE INFOMATION------");
		System.out.print("Enter department name: ");
		department.setDepartmentName(scanner.nextLine());
		return department;
	}

	public void showEmp(List<Employee> listEmployees) {
		for (Employee employee : listEmployees) {
			System.out.println(employee.toString());
		}
	}

	public List<Department> getDataDepartment(List<Department> departments) {
		List<Department> listDataDepartment = new ArrayList<>();
		for (Department department : departments) {
			Department dataDepartment = new Department();
			dataDepartment.setDepartmentName(department.getDepartmentName());
			listDataDepartment.add(dataDepartment);
		}
		return listDataDepartment;
	}

	public List<Employee> searchEmployeeByEmployeeCondition(String conditionSearch, List<Employee> employees) {
		List<Employee> listEmployeeSearchEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getLastName().equals(conditionSearch) || employee.getFirstName().equals(conditionSearch)) {
				listEmployeeSearchEmployees.add(employee);
			}
		}
		return listEmployeeSearchEmployees;
	}

	public List<Employee> searchEmployeeByDeparmentCondition(String conditionSearch, List<Department> departments) {
		for (Department department : departments) {
			if (department.getDepartmentName().equals(conditionSearch)) {
				return department.getListEmployees();
			}
		}
		return Collections.emptyList();
	}
}
