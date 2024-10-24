package JPLxx.fa.entities;

import java.util.Scanner;

public class Sale {
	Scanner sc = new Scanner(System.in);

	private int ID;
	private String Name;
	private int Age;
	private String Address;
	private double Salary;
	private int SumTimeWork;
	public static int Sale_Count;

	private double bonus;

	public Sale() {
		Sale_Count++;
	}

	public Sale(String name, int age, String address, double salary, int sumTimeWork) {
		super();
		Name = name;
		Age = age;
		Address = address;
		Salary = salary;
		SumTimeWork = sumTimeWork;
		Sale_Count++;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public int getSumTimeWork() {
		return SumTimeWork;
	}

	public void setSumTimeWork(int sumTimeWork) {
		SumTimeWork = sumTimeWork;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public void inputInfo() {
		System.out.print("Nhập tên saler: ");
		Name = sc.nextLine();

		System.out.print("Nhập tuổi saler: ");
		Age = Integer.parseInt(sc.nextLine());

		System.out.print("Nhập địa chỉ: ");
		Address = sc.nextLine();

		System.out.print("Nhập tổng giờ làm: ");
		SumTimeWork = Integer.parseInt(sc.nextLine());

		System.out.print("Nhập mức lương: ");
		Salary = Double.parseDouble(sc.nextLine());

		System.out.println("===================================================");
	}

	public void printInfo() {
		System.out.println("\n\nID: " + ID + " || Saler: " + Name + " || Age: " + Age + " || Địa chỉ: " + Address
				+ " || Tổng giờ làm: " + SumTimeWork + " || Mức lương: " + Salary);
	}

	public double getBonus() {

		if (this.SumTimeWork >= 200) {
			this.bonus = this.Salary * 0.20d;
		} else if (this.SumTimeWork >= 100) {
			this.bonus = this.Salary * 0.1d;
		} else {
			this.bonus = 0;
		}

		return bonus;
	}

}
