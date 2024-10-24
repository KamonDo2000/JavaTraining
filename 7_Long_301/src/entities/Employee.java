package entities;

public class Employee {

	private String employee_id;
	private String employee_name;
	private float salary;
	private String supervisor_id;

	public Employee() {

	}

	public Employee(String employee_id, String employee_name, float salary, String supervisor_id) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.salary = salary;
		this.supervisor_id = supervisor_id;
	}

	/**
	 * @return the employee_id
	 */
	public synchronized String getEmployee_id() {
		return employee_id;
	}

	/**
	 * @param employee_id the employee_id to set
	 */
	public synchronized void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	/**
	 * @return the employee_name
	 */
	public synchronized String getEmployee_name() {
		return employee_name;
	}

	/**
	 * @param employee_name the employee_name to set
	 */
	public synchronized void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	/**
	 * @return the salary
	 */
	public synchronized float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public synchronized void setSalary(float salary) {
		this.salary = salary;
	}

	/**
	 * @return the supervisor_id
	 */
	public synchronized String getSupervisor_id() {
		return supervisor_id;
	}

	/**
	 * @param supervisor_id the supervisor_id to set
	 */
	public synchronized void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

}
