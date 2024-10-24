package view;

import java.util.ArrayList;
import java.util.List;

import controller.AddPerson;
import controller.ShowTeacher;
import controller.UpdateSV;
import model.Person;
import model.Student;
import model.Teacher;

public class PersonManager {
	public static void main(String[] args) {
		List<Person> arrPer = new ArrayList<>();
		do {
			int pick = Menu.menu();

			switch (pick) {
			case 0:
				break;
			case 1:
				arrPer = AddPerson.add();
				fakeData(arrPer);
				continue;
			case 2:
				ShowPerson.show(arrPer);
				continue;
			case 3:
				UpdateSV.updateSV(arrPer);
				continue;
			case 4:
				ShowTeacher.showteach(arrPer);
				continue;
			case 5:
				ShowTeacher.showStudent(arrPer);
				continue;
			default:
				break;
			}
		} while (true);

	}

	private static void fakeData(List<Person> arr) {
		Student stu = new Student();
		stu.setStudentId("SV001");
		stu.setFullName("Do Gia Bin");
		stu.setGender("Nam");
		stu.setEmail("huydo@gmail.com");
		stu.setPhone("0774053798");
		stu.setPractice(9);
		stu.setTheory(8);

		Student stu1 = new Student();
		stu1.setStudentId("SV002");
		stu1.setFullName("Do Gia Huy");
		stu1.setGender("Nam");
		stu1.setEmail("huydo234@gmail.com");
		stu1.setPhone("0774053982");
		stu1.setPractice(6);
		stu1.setTheory(7);

		Student stu2 = new Student();
		stu2.setStudentId("SV003");
		stu2.setFullName("Do Van Vien");
		stu2.setGender("Nu");
		stu2.setEmail("jiauysdn@gmail.com");
		stu2.setPhone("0774983982");
		stu2.setPractice(5);
		stu2.setTheory(9);

		Teacher tea = new Teacher();
		tea.setFullName("Nguyen Van A");
		tea.setGender("Nam");
		tea.setEmail("huysj@gmail.com");
		tea.setPhone("0786647387");
		tea.setBasicSalary(4000);
		tea.setSubSidy(340);

		Teacher tea1 = new Teacher();
		tea1.setFullName("Nguyen The Phien");
		tea1.setGender("Nu");
		tea1.setEmail("sdjias@gmail.com");
		tea1.setPhone("0786623887");
		tea1.setBasicSalary(5000);
		tea1.setSubSidy(250);

		Teacher tea2 = new Teacher();
		tea2.setFullName("Nguyen Van Kien");
		tea2.setGender("Nam");
		tea2.setEmail("hahsdjiw@gmail.com");
		tea2.setPhone("0786239887");
		tea2.setBasicSalary(3600);
		tea2.setSubSidy(299);

		arr.add(tea);
		arr.add(stu);
		arr.add(stu1);
		arr.add(tea1);
		arr.add(tea2);
		arr.add(stu2);

	}
}
