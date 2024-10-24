package day6.Opt2;

import java.util.Scanner;

import common.func;
import common.student;

public class Ass5 {

//	Viết đoạn chương trình:
//		a)     Nhập số lượng (N) Học viên, khai báo mảng chứa tên học viên,
//		mảng chứa điểm Topic: SQL Basic,  mảng chưa điểm Java Basic 
//		và mảng chứa Java Advanced cho từng học viên
//		b)     Viết hàm Nhập tên học viên, nhập điểm các topic của từng học viên:
//			SQL Basic, Java Basic, Java Advanced vào các mảng tương ứng
//		c)     Hiển thị các giá trị đã nhập vào các mảng ở b)
//		d)     Tính và hiển thị điểm trung bình của các học viên
//		e)     Viết hàm hiển thị các học viên có điểm trung bình chung các Topic >= 6.5	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập số lượng học viên của trung tâm: ");
		int N = input.nextInt();

		String[] studentName;
		float[] markSQLBase;
		float[] markJBase;
		float[] markJAdvand;

		studentName = student.inputNameStuden(N);

		System.out.println("\nNhập điểm SQL Basic cho HV: ");
		markSQLBase = student.inputMark(N);

		System.out.println("\nNhập điểm Java Basic cho HV: ");
		markJBase = student.inputMark(N);

		System.out.println("\nNhập điểm Java Advanced cho HV: ");
		markJAdvand = student.inputMark(N);

		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.println("Học Viên: " + studentName[i] + "\t|\tĐiểm SQL: " + markSQLBase[i]
					+ "\t|\tĐiểm Java Basic: " + markJBase[i] + "\t|\tĐiểm Java Advanced: " + markJAdvand[i] + "\n");
		}

		float[] markAverage = new float[N];
		System.out.println();
		for (int i = 0; i < N; i++) {
			markAverage[i] = (markSQLBase[i] + markJBase[i] + markJAdvand[i]) / 3f;
		}

		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.println("Học Viên: " + studentName[i] + "\t|\tĐiểm Trung Bình:  " + markAverage[i]);
		}
		showSinhVien(markAverage, studentName);

	}

	static void showSinhVien(float[] markAverage, String[] studentName) {
		System.out.println("\n Những học viên điểm số > 6.5");
		for (int i = 0; i < studentName.length; i++) {
			if (markAverage[i] > 6.5f) {
				System.out.println("Học Viên: " + studentName[i] + "\t|\tĐiểm Trung Bình:  " + markAverage[i]);
			}
		}
	}

}
