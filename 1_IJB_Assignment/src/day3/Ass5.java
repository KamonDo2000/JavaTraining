package day3;

import java.util.Scanner;

public class Ass5 {

//	Viết chương trình Java để phát hiện các phím bấm.
//	Nếu người dùng nhấn các phím số (từ 0 đến 9), chương trình sẽ cho biết số được nhấn,
//	ngược lại, chương trình sẽ hiển thị "Không được phép"

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String in;
		System.out.print("Nhap vao 1 ky tu so: ");
		in = input.next();

		switch (in) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			System.out.print("\nKy tu so moi nhap vao:  " + in);
			break;
		default:
			System.out.print("\nKhông được phép");
			break;
		}
	}

}
