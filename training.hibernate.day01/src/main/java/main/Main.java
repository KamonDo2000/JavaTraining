package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAO.EmpDaoImpl;
import entities.Employee;

public class Main {
	static EmpDaoImpl dao = new EmpDaoImpl();

	public static void main(String[] args) {

		List<Employee> listEmp = new ArrayList<>(Arrays.asList(new Employee(6, "John Doe", "john.doe@example.com"),
				new Employee(7, "Jane Doe", "jane.doe@example.com"),
				new Employee(8, "Bob Smith", "bob.smith@example.com")));

		dao.saveList(listEmp);

//		DAO.delete(103);

		List<Employee> listEm = dao.getAllEmployees();

		for (Employee emp : listEm) {
			System.out.println(emp.getId() + " || " + emp.getFirstName() + " || " + emp.getLastName());
		}
	}

}
