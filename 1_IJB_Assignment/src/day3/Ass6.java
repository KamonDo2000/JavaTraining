package day3;

import java.util.Scanner;

public class Ass6 {

//	Viết một chương trình Java cho phép người dùng chọn câu trả lời đúng của một câu hỏi.
//	Xem ví dụ bên dưới:
//	Cách chính xác để khai báo một biến để lưu trữ một giá trị số nguyên trong Java là gì?
//	a. int 1x = 10;
//	b. int x = 10;
//	c. float x = 10.0f;
//	d. chuỗi x = "10";
//	Nhập sự lựa chọn của bạn: c

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String answer;
		System.out.println("Cách chính xác để khai báo một biến để lưu trữ một giá trị số nguyên trong Java là gì?\n"
				+ "	a. int 1x = 10;\n" + "	b. int x = 10;\n" + "	c. float x = 10.0f;\n"
				+ "	d. chuỗi x = \"10\";");
		do {
			System.out.print("\nNhập Đáp Án:  ");
			answer = in.nextLine();

			switch (answer) {
			case "a":
			case "A":
				System.out.println("Câu trả lời sai.");
				break;
			case "b":
			case "B":
				System.out.println("Câu trả lời sai.");
				break;
			case "c":
			case "C":
				System.out.println("Câu trả đúng!!!.");
				break;
			case "d":
			case "D":
				System.out.println("Câu trả lời sai.");
				break;
			default:
				System.out.print("\nchỉ có câu trả lời a | b | c | d");
			}
		} while (!answer.equals("c") && !answer.equals("C")); //Vì String là object nên so sánh phải .equals
	}
}
