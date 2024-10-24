package JPLxx.fa.main;

import java.util.ArrayList;
import java.util.Scanner;

import JPLxx.fa.entities.Student;

public class MyManagerStudent {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Student> student = new ArrayList<Student>();
		Student st;
		int pick;
		while (true) {
			pick = menu();

			switch (pick) {
			case 1:
				st = new Student();
				st.inputInfo();
				student.add(st);
				System.out.println("\n");
				break;
			case 2:
				if (student.size() == 0) {
					System.out.println("Chưa có sinh viên");
				} else {
					for (int i = 0; i < student.size(); i++) {
						student.get(i).showInfo();
						System.out.println();
					}
				}
				System.out.println("\n");
				break;
			case 3:
				if (student.size() == 0) {
					System.out.println("Chưa có sinh viên");
				} else {
					System.out.println("\nCác sinh viên có học bổng: ");
					for (int i = 0; i < student.size(); i++) {
						st = student.get(i);
						if (st.checkHocBong(st.getDiemTB())) {
							st.showInfo();
							System.out.println();
						}
					}
				}
				System.out.println("\n");
				break;
			case 0:
				return;
			}
		}

	}

	private static int menu() {
		int pick;
		System.err.println("=====Chương Trình quản lý sinh Viên=====");
		System.err.println("1. Nhập thông tin sinh viên.");
		System.err.println("2. Hiển thị danh sách thông tin sinh viên.");
		System.err.println("3. Hiển thị danh sách thông tin sinh viên có học bổng.");
		System.err.println("0. Quit");
		System.err.println("========================================");

		do {
			System.err.print("Lựa chọn của bạn:   ");
			pick = sc.nextInt();
			System.out.println("\n");
			if (pick != 1 && pick != 2 && pick != 3 && pick != 0) {
				System.err.println("Chỉ có thể nhập 1, 2, 3, 0!!!");
			}
		} while (pick != 1 && pick != 2 && pick != 3 && pick != 0);

		return pick;
	}

}
