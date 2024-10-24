package view;

import java.util.List;

import model.Course;

public class ShowCourse {

	public static void find(String type, String data, List<Course> arrList) {
		for (Course c : arrList) {
			if (type.equalsIgnoreCase("courseCode") && data.equalsIgnoreCase(c.getCourseCode())) {
				showCourse(c);
			} else if (type.equalsIgnoreCase("courseName") && data.equalsIgnoreCase(c.getCourseName())) {
				showCourse(c);
			} else if (type.equalsIgnoreCase("status") && data.equalsIgnoreCase(c.getStatus())) {
				showCourse(c);
			} else if (type.equalsIgnoreCase("flag") && data.equalsIgnoreCase(c.getFlag())) {
				showCourse(c);
			} else if (type.equalsIgnoreCase("duration")) {
				try {
					double duration = Double.parseDouble(data);
					if (duration == c.getDuration()) {
						showCourse(c);
					}
				} catch (Exception e) {
					break;
				}
			} else {
				System.err.println("Kiem tra lai type and value");
			}
		}
	}

	public static void showCourse(Course c) {
		System.out.println(c.getCourseCode());
		System.out.println(c.getCourseName());
		System.out.println(c.getDuration());
		System.out.println(c.getStatus());
		System.out.println(c.getFlag());
	}

	public static void showListCourse(List<Course> arrList) {
		for (Course c : arrList) {
			System.out.println(c.getCourseCode());
			System.out.println(c.getCourseName());
			System.out.println(c.getDuration());
			System.out.println(c.getStatus());
			System.out.println(c.getFlag());
		}
	}
}
