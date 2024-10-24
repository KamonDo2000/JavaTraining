package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Department;
import model.Employee;
import model.HourlyEmployee;
import model.SalariedEmployee;
import utils.CheckValidDate;
import utils.DateException;
import utils.EmailException;
import utils.Validator;

public class EmployeeService {
	static CheckValidDate checkValidDate = new CheckValidDate();
	Scanner scanner = new Scanner(System.in);

	public Employee createEmployee(int typeEmployee) {
		Employee employee = null;
		switch (typeEmployee) {
		case 1:
			employee = new SalariedEmployee();
			break;
		case 2:
			employee = new HourlyEmployee();
			break;
		default:
			break;
		}

		System.out.println("------ENTER EMPLOYEE INFOMATION------");
		System.out.print("Enter SSN: ");
		employee.setSsn(scanner.nextLine());
		System.out.println("");
		System.out.print("Enter firstname: ");
		employee.setFirstName(scanner.nextLine());
		System.out.println("");
		System.out.print("Enter lastname: ");
		employee.setLastName(scanner.nextLine());
		System.out.println("");
		System.out.print("Enter phone number: ");
		String phoneNumberString = null;
		do {
			phoneNumberString = scanner.next();
		} while (Validator.isMatchRegexPhone(phoneNumberString));
		employee.setPhone(phoneNumberString);
		System.out.println("");
		System.out.print("Enter email: ");
		String validEmail = null;
		do {
			try {
				validEmail = scanner.next();
				Validator.checkEmail(validEmail);
				Validator.isMatchRegexEmail(validEmail);
				employee.setEmail(validEmail);
				break;
			} catch (EmailException e) {
				e.printStackTrace();
				System.out.println("Email not match with format. Please try again: ");
			}
		} while (true);
		employee.setEmail(validEmail);
		System.out.println("");
		System.out.print("Enter birthdate with format (dd/MM/yyyy): ");
		Date dateInputBirthdate = null;
		do {
			try {
				String dateString = scanner.next();
				checkValidDate.checkValidDate(dateString);
				dateInputBirthdate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
				employee.setBirthDate(dateInputBirthdate);
				break;
			} catch (DateException e) {
				e.printStackTrace();
				System.out.println("Date not match with format (dd/MM/yyyy). Please try again: ");
			} catch (ParseException e) {
				System.out.println("Date not match with format (dd/MM/yyyy). Please try again: ");
			}
		} while (true);
		switch (typeEmployee) {
		case 1:
			System.out.println("");
			System.out.print("Enter basic salary: ");
			((SalariedEmployee) employee).setBasicSalary(scanner.nextDouble());
			System.out.println("");
			System.out.print("Enter max fixed wing parking place: ");
			((SalariedEmployee) employee).setGrossSales(scanner.nextDouble());
			System.out.println("");
			System.out.print("Enter max rotated wing parking place: ");
			((SalariedEmployee) employee).setCommisstionRate(scanner.nextDouble());
			break;
		case 2:
			System.out.println("");
			System.out.print("Enter max fixed wing parking place: ");
			((HourlyEmployee) employee).setRate(scanner.nextDouble());
			System.out.println("");
			System.out.print("Enter max rotated wing parking place: ");
			((HourlyEmployee) employee).setWorkingHours(scanner.nextDouble());
			break;
		default:
			break;
		}
		return employee;
	}

	public void showEmp(List<Employee> listEmployees) {
		for (Employee employee : listEmployees) {
			System.out.println(employee.toString());
		}
	}

	public List<Employee> getDataEmployee(List<Employee> employees) {
		List<Employee> listDataEmployees = new ArrayList<>();
		for (Employee employeeInList : employees) {
			if (employeeInList instanceof SalariedEmployee) {
				Employee employee = new SalariedEmployee();
				employee.setSsn(employeeInList.getSsn());
				employee.setFirstName(employeeInList.getFirstName());
				employee.setLastName(employeeInList.getLastName());
				employee.setBirthDate(employeeInList.getBirthDate());
				employee.setPhone(employeeInList.getPhone());
				employee.setEmail(employeeInList.getEmail());
				((SalariedEmployee) employee).setBasicSalary(((SalariedEmployee) employeeInList).getBasicSalary());
				((SalariedEmployee) employee).setGrossSales(((SalariedEmployee) employeeInList).getGrossSales());
				((SalariedEmployee) employee)
						.setCommisstionRate(((SalariedEmployee) employeeInList).getCommisstionRate());
				listDataEmployees.add(employee);
			}
			if (employeeInList instanceof HourlyEmployee) {
				Employee employee = new HourlyEmployee();
				employee.setSsn(employeeInList.getSsn());
				employee.setFirstName(employeeInList.getFirstName());
				employee.setLastName(employeeInList.getLastName());
				employee.setBirthDate(employeeInList.getBirthDate());
				employee.setPhone(employeeInList.getPhone());
				employee.setEmail(employeeInList.getEmail());
				((HourlyEmployee) employee).setRate(((HourlyEmployee) employeeInList).getRate());
				((HourlyEmployee) employee).setWorkingHours(((HourlyEmployee) employeeInList).getWorkingHours());
				listDataEmployees.add(employee);
			}
		}
		return listDataEmployees;
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
