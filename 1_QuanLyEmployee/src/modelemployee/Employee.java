package modelemployee;

public class Employee {
	private long id;
	private String name;
	private int age;
	private String address;
	private double salary;
	private int sumTimeWork;

	public Employee(long id, String name, int age, String address, double salary, int sumTimeWork) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
		this.sumTimeWork = sumTimeWork;
	}
	
	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getSumTimeWork() {
		return sumTimeWork;
	}

	public void setSumTimeWork(int sumTimeWork) {
		this.sumTimeWork = sumTimeWork;
	}
	
}
