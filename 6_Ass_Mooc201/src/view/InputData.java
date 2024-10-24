package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Course;

public class InputData {

	static Scanner sc = new Scanner(System.in);

	private static final String RG_CODE = "^FW[\\d]{3}$";
	private static final String RG_NAME = "^[a-zA-Z ]{5,}$";

	public static List<Course> inputData() {

		List<Course> arrCourse = new ArrayList<>();
		do {
			int pick = menu();

			switch (pick) {
			case 0:
				return arrCourse;
			case 1:
				Course course = input();
				arrCourse.add(course);
			default:
			}
		} while (true);
		
	}

	private static int menu() {
		int pick;
		do {
			System.out.println("Nhap Lua Chon: ");
			System.out.println("\t\tInput Data: 1");
			System.out.println("\t\tConfirm: 0");
			try {
				pick = Integer.parseInt(sc.nextLine());
				if (pick < 0 && pick > 1) {
					System.out.println("chi 1 va 0");
					continue;
				}
				return pick;
			} catch (Exception e) {
				System.out.println("nhap sai");
				continue;
			}
		} while (true);
	}

	private static Course input() {
		Course course = new Course();
		course.setCourseCode(inCourseCode());
		course.setCourseName(inName());
		course.setDuration(inDuration());
		course.setStatus(inStatus());
		course.setFlag(inFlag());
		return course;
	}

	private static String inCourseCode() {
		String courseCode = null;
		do {
			System.out.println("Nhap Ma MH");
			courseCode = sc.nextLine();
			if (!courseCode.matches(RG_CODE)) {
				System.err.println("VD: FW005");
			}
		} while (!courseCode.matches(RG_CODE));
		return courseCode;
	}

	private static String inName() {
		String name = null;
		do {
			System.out.println("Nhap name");
			name = sc.nextLine();
			if (!name.matches(RG_NAME)) {
				System.err.println("Min 5 text");
			}
		} while (!name.matches(RG_NAME));
		return name;
	}

	private static double inDuration() {
		double duration = 0;
		do {
			try {
				System.out.println("Nhap Duration");
				duration = Double.parseDouble(sc.nextLine());

				if (duration < 0) {
					System.err.println("duration > 0");
					continue;
				}

				break;
			} catch (Exception e) {
				System.err.println("input double");
				continue;
			}
		} while (true);
		return duration;
	}

	private static String inStatus() {
		String st = null;
		do {
			System.out.println("Nhap status");
			st = sc.nextLine();
			if (!st.equalsIgnoreCase("active") && !st.equalsIgnoreCase("in-active")) {
				System.err.println("accept 'active' or 'in-active'");
			}
		} while (!st.equalsIgnoreCase("active") && !st.equalsIgnoreCase("in-active"));
		return st;
	}

	private static String inFlag() {
		String flg = null;
		do {
			System.out.println("Nhap Flag");
			flg = sc.nextLine();
			if (!flg.equalsIgnoreCase("optional") && !flg.equalsIgnoreCase("mandatory")
					&& !flg.equalsIgnoreCase("N/A")) {
				System.err.println("accept 'optional', 'mandatory', 'N/A'");
			}
		} while (!flg.equalsIgnoreCase("optional") && !flg.equalsIgnoreCase("mandatory")
				&& !flg.equalsIgnoreCase("N/A"));
		return flg;
	}

}
