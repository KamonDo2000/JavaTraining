package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Course;

public class CourseManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Course> arrPer = new ArrayList<>();
		do {
			int pick = Menu.menu();

			switch (pick) {
			case 0:
				sc.close();
				return;
			case 1:
				arrPer = InputData.inputData();
				continue;
			case 2:
				ShowCourse.showListCourse(arrPer);
				continue;
			case 3:
				System.out.print("Nhap type");
				String type = sc.nextLine();
				System.out.print("Nhap data");
				String data = sc.nextLine();

				ShowCourse.find(type, data, arrPer);

				continue;
			case 4:

				for (Course c : arrPer) {
					if (c.getFlag().equalsIgnoreCase("mandatory")) {
						ShowCourse.showCourse(c);
					}
				}

				continue;
			default:
				break;
			}
		} while (true);

	}

}
