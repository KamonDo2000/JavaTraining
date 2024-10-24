package DAO;

import java.util.List;

import entities.Employee;

public interface EmpDao {
	void save(Employee e);

	void saveList(List<Employee> e);

	void delete(int id);

	List<Employee> getAllEmployees();

}
