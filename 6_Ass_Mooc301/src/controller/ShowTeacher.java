package controller;

import java.util.List;

import model.Person;
import model.Student;
import model.Teacher;

public class ShowTeacher {

	public static void showteach(List<Person> arrPer) {
		for (Person per : arrPer) {
			if (per instanceof Teacher && ((Teacher) per).getBasicSalary() > 1000) {
				show(per);
				System.out.println(((Teacher) per).getBasicSalary());
				System.out.println(((Teacher) per).getSubSidy());
				System.out.println();
			}
		}
	}

	public static void showStudent(List<Person> arrPer) {
		for (Person per : arrPer) {
			if (per instanceof Student && ((Student) per).calculateFinalMark() > 6) {
				System.out.println(((Student) per).getStudentId());
				show(per);
				System.out.println(((Student) per).calculateFinalMark());
				System.out.println();

			}
		}
	}

	private static void show(Person per) {
		System.out.println(per.getFullName());
		System.out.println(per.getGender());
		System.out.println(per.getEmail());
		System.out.println(per.getPhone());
	}

}
