package String_Opt;

import java.sql.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Ass8 {
//	Cho chuỗi “Hello” và chuỗi “World” và Hãy tạo thành chuỗi “ Hello World ”
//	Nhập vào một String S, thực hiện công việc sau:
//	a.       In ra màn hình String đảo ngược của S
//	b.       Đổi toàn bộ kí tự của S sang chữ Hoa
//	c.       Đổi toàn bộ kí tự của S sang chữ thường
//	d.       Đưa ra bảng tần số xuất hiện của các kí tự trong S
//	e.       Trích ra chuỗi con của S từ kí tự thứ n đến thứ m của S (n, m nhập từ bàn phím)

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "World";
		String str3 = " ".concat(str1).concat(" ").concat(str2).concat(" ");
		System.out.println(str3);

		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap S: ");
		String s = sc.nextLine();

		System.out.println("===========");
		char[] arr = s.toCharArray();
		for (int i = arr.length - 1; i >= 0; --i) {
			System.out.print(arr[i]);
		}
		System.out.println("\n===========");
		System.out.println(s.toUpperCase());
		System.out.println("===========");

		System.out.println(s.toLowerCase());
		System.out.println("===========");

//		&& arr[i] != 0
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int i_1 = i + 1; i_1 < arr.length; i_1++) {
				if (arr[i] == arr[i_1]) {
					++count;
					arr[i_1] = 0;
				}
			}
			if (arr[i] != 0) {
				System.out.println("ky tu " + arr[i] + " xuat hien " + count + " lan");
			}

		}
		int n = 0, m = 0;
		System.out.println("===========");
		try {
			System.out.print("\nNhap N: ");
			n = Integer.parseInt(sc.nextLine());
			System.out.print("\nNhap M: ");
			m = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("N M phai la so nguyen");
		}

		if (n > m) {
			n = n + m;
			m = n - m;
			n = n - m;
		}
		if (m > s.length()) {
			m = s.length();
		}
		System.out.println(s.substring(n, m));
	}

}
