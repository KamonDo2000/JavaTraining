package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import service.EmployeeService;
import service.FileService;
import model.Department;
import model.Employee;
import model.HourlyEmployee;
import model.SalariedEmployee;
import utils.CheckValidDate;
import utils.Validator;

public class EmployeeManagement {
	static Scanner sc = new Scanner(System.in);

	static List<Employee> employees = new ArrayList<>();
	static Validator validator = new Validator();
	static CheckValidDate checkValidDate = new CheckValidDate();
	static FileService fileService = new FileService();
	static EmployeeService employeeService = new EmployeeService();
	static List<Department> departments = new ArrayList<>();

	public static void main(String[] args) {
//		departments = fileService.readDataFromFileDepartment();
//		employees = fileService.readDataFromFile(departments);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		for (Department department : departments) {
			System.out.println(department.toString());
		}
		menu();
	}

	private static void menu() {
		do {
			int choose = Menu.menuFunction();
			switch (choose) {
			case 1:
				chooseTypeEmployee();
				continue;
			case 2:
				employeeService.showEmp(employees);
				continue;
			case 3:
				if (!employees.isEmpty()) {
					for (Employee employee : employees) {
						if (employee instanceof SalariedEmployee) {
							System.out.println("SalariedEmployee");
							System.out.println(employee.toString());
						}
						if (employee instanceof HourlyEmployee) {
							System.out.println("HourlyEmployee");
							System.out.println(employee.toString());
						}
					}
				} else {
					System.out.println("Data is empty !!!");
				}
				continue;
			case 4:
				searchEmployee();
				break;
			case 5:
				for (Department department : departments) {
					System.out.println(department.toString());
				}
				break;
			case 6:
				System.out.println("The program has ended !!!");
				return;
			}
		} while (true);
	}

	private static void chooseTypeEmployee() {
		int choose = 0;
		do {
			System.out.println("Choose function: ");
			System.out.println("1. Add a new Salaried Employee");
			System.out.println("2. Add a new Hourly Employee");
			System.out.println("3. Exit");
			do {
				try {
					choose = Integer.parseInt(sc.nextLine());
					if (choose == 1 || choose == 2) {
						break;
					} else if (choose == 3) {
						return;
					}
					System.out.println("0-3, Please try again: ");
				} catch (Exception e) {
					System.out.println("Only number, Please try again: ");
				}
			} while (true);
			employees.add(employeeService.createEmployee(choose));
			fileService.writeDataFromFileCSV(employees);
		} while (true);
	}

	private static void searchEmployee() {
		List<Employee> listSearchEmployees = new ArrayList<>();
		System.out.println("1. Search by department name");
		System.out.println("2. Search by  by employee name");
		System.out.println("3. Exit");

		int choose = 0;
		do {
			try {
				choose = Integer.parseInt(sc.nextLine());
				if (choose == 1 || choose == 2) {
					break;
				} else if (choose == 3) {
					return;
				}
				System.out.println("1-3, Please try again: ");
			} catch (Exception e) {
				System.out.println("Only number, Please try again: ");
			}
		} while (true);
		System.out.println("Enter condition search: ");
		String condition = sc.nextLine();
		if (choose == 1) {
			listSearchEmployees = employeeService.searchEmployeeByDeparmentCondition(condition, departments);
		}
		if (choose == 2) {
			listSearchEmployees = employeeService.searchEmployeeByEmployeeCondition(condition, employees);
		}
		for (Employee employee : listSearchEmployees) {
			System.out.println(employee.toString());
		}
	}
}
