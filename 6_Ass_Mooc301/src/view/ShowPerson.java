package view;

import java.util.List;

import model.Person;
import model.Student;
import model.Teacher;

public class ShowPerson {

	public static void show(List<Person> arrPer) {
	
		for (Person per : arrPer) {
			if (per instanceof Student) {
				System.out.println(((Student) per).getStudentId());
				System.out.println(per.getFullName());
				System.out.println(per.getGender());
				System.out.println(per.getEmail());
				System.out.println(per.getPhone());
				System.out.println(((Student) per).getPractice());
				System.out.println(((Student) per).getTheory());
			}
			if (per instanceof Teacher) {
				System.out.println(per.getFullName());
				System.out.println(per.getGender());
				System.out.println(per.getEmail());
				System.out.println(per.getPhone());
				System.out.println(((Teacher) per).getBasicSalary());
				System.out.println(((Teacher) per).getSubSidy());
			}

			System.out.println();
		}
	}

}
