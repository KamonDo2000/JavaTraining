package viewemployee;

import java.util.ArrayList;

import modelemployee.Employee;

public class view_Employee {

	public static void viewAll(ArrayList<Employee> arrEmployees) {
		if (arrEmployees.size() != 0) {
			for (int i = 0; i < arrEmployees.size(); i++) {
				System.out.println(arrEmployees.get(i).getId());
				System.out.println(arrEmployees.get(i).getName());
				System.out.println(arrEmployees.get(i).getAge() + " Tuổi");
				System.out.println(arrEmployees.get(i).getAddress());
				System.out.println(arrEmployees.get(i).getSalary() + " USD");
				System.out.println(arrEmployees.get(i).getSumTimeWork() + " Giờ");
				System.out.println("=====================================================\n");
			}
		} else {
			System.out.println("Không có nhân viên nào!!");
		}

	}

}
