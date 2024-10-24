package General_Ass_Day1;

import java.util.Scanner;

public class Ex5 {

	static Scanner sc = new Scanner(System.in);

	public static void show() {
		int a;
		do {
			System.out.println("Input value a: ");
			a = Integer.parseInt(sc.nextLine());
			break;
		} while (true);

		int b;
		do {
			System.out.println("Input value b: ");
			b = Integer.parseInt(sc.nextLine());
			break;
		} while (true);

		System.out.println("ước số chung lớn nhất "+uCLN(a, b));
		int bCNN = (a + b) / uCLN(a, b);
		System.out.println("bội số chung nhỏ nhất "+bCNN);
	}

	public static int uCLN(int bnum, int snum) {
//		giải thuật Euclid tìm UCLN dư khác 0 thì lấy số chia chia lại cho dư|| 81 / 57 dư 24 thì lấy 57 /24
		if (snum > bnum) {
			bnum = bnum + snum;
			snum = bnum - snum;
			bnum = bnum - snum;
		}

		int modNum = bnum % snum;
		if (modNum == 0) {
			return snum;
		}
		return uCLN(snum, modNum);
	}

}
