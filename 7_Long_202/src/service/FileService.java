package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import model.Department;
import model.Employee;
import model.HourlyEmployee;
import model.SalariedEmployee;
import utils.EmailException;
import utils.Validator;

public class FileService {

	EmployeeService employeeService = new EmployeeService();
	DepartmentService departmentService = new DepartmentService();

	public List<Employee> readDataFromFile(List<Department> listDepartments) {
		List<String> list = new ArrayList<>();
		List<Employee> employees = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("employeesInputt.csv"));
			do {
				String line = null;
				line = br.readLine();
				list.add(line);
			} while (br.ready());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String string : list) {
			String[] array = string.split(",");
			Date date = null;
			if (Validator.isMatchRegexPhone(array[4])) {
				continue;
			}
			if (Validator.isMatchRegexEmail(array[5])) {
				continue;
			}
			try {
				Validator.checkEmail(array[5]);
			} catch (EmailException e) {
				e.printStackTrace();
				continue;
			}
			if (array[6].equalsIgnoreCase("null")) {
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(array[3]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				HourlyEmployee hourlyEmployee = new HourlyEmployee(array[0], array[1], array[2], date, array[4],
						array[5], Double.parseDouble(array[9]), Double.parseDouble(array[10]));
				employees.add(hourlyEmployee);
				for (Department department : listDepartments) {
					if (array[11].equals(department.getDepartmentName())) {
						List<Employee> employeesDepartment = department.getListEmployees();
						employeesDepartment.add(hourlyEmployee);
						department.setListEmployees(employeesDepartment);
					}
				}
			} else {
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(array[3]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				SalariedEmployee salariedEmployee = new SalariedEmployee(array[0], array[1], array[2], date, array[4],
						array[5], Double.parseDouble(array[6]), Double.parseDouble(array[7]),
						Double.parseDouble(array[8]));
				employees.add(salariedEmployee);
				for (Department department : listDepartments) {
					if (array[11].equals(department.getDepartmentName())) {
						List<Employee> employeesDepartment = (department.getListEmployees() != null
								? department.getListEmployees()
								: new ArrayList<Employee>());
						employeesDepartment.add(salariedEmployee);
						department.setListEmployees(employeesDepartment);
					}
				}
			}
		}
		return employeeService.getDataEmployee(employees);
	}

	public void writeDataFromFileCSV(List<Employee> listEmployees) {
		BufferedWriter bw = null;
		try {
			File file = new File("employeesOutput.csv");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for (Employee employee : listEmployees) {
				bw.write(employee.writeFile());
				bw.newLine();
			}
			System.out.println("File written Successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}

	}

	public List<Department> readDataFromFileDepartment() {
		List<String> list = new ArrayList<>();
		List<Department> departments = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("departmentInput.csv"));
			do {
				String line = null;
				line = br.readLine();
				list.add(line);
			} while (br.ready());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (String string : list) {
			String[] array = string.split(",");
			System.out.println(Arrays.toString(array));
			List<Employee> employeesList = new ArrayList<>();
			Department department = new Department(array[0], employeesList);
			departments.add(department);
		}
		return departmentService.getDataDepartment(departments);
	}

	public void writeDataDepartmentFromFileCSV(List<Department> listDepartments) {
		BufferedWriter bw = null;
		try {
			File file = new File("departmentOutput.csv");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for (Department department : listDepartments) {
				bw.write(department.writeFile());
				bw.newLine();
			}
			System.out.println("File written Successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}

	}
}
