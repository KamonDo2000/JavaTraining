package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Person;
import model.Student;
import model.Teacher;
import view.InputData;

public class AddPerson {

	static Scanner sc = new Scanner(System.in);

	public static List<Person> add() {
		List<Person> arrPer = new ArrayList<>();

		Person stu = new Student();
		Person tea = new Teacher();

		do {
			int check = 0;
			System.err.println("1. add studen");
			System.err.println("2. add teacher");
			System.err.println("3. confirm");
			try {
				check = sc.nextInt();
			} catch (Exception e) {
				System.out.println("chi có 1,2,3");
				continue;
			}

			switch (check) {
			case 1:
				stu = addStu();
				arrPer.add(stu);
				continue;
			case 2:
				tea = addTea();
				arrPer.add(tea);
				continue;
			case 3:
				break;
			default:
				System.out.println("Khong lua chon");
				continue;
			}

			break;
		} while (true);

		return arrPer;
	}

	private static Person addStu() {
		Student stu = new Student();

		stu.setStudentId(InputData.inputID());
		stu.setFullName(InputData.inputName());
		stu.setGender(InputData.inGender());
		stu.setEmail(InputData.inEmail());
		stu.setPhone(InputData.inPhone());
		stu.setPractice(InputData.inputPractice());
		stu.setTheory(InputData.inputTheory());

		return stu;
	}

	private static Person addTea() {
		Teacher tea = new Teacher();

		tea.setFullName(InputData.inputName());
		tea.setGender(InputData.inGender());
		tea.setEmail(InputData.inEmail());
		tea.setPhone(InputData.inPhone());
		tea.setBasicSalary(InputData.inputSalary());
		tea.setSubSidy(InputData.inputSubsidy());

		return tea;
	}
}
