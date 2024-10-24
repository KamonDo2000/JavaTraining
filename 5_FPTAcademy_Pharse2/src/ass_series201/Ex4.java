package ass_series201;

import java.util.Scanner;

public class Ex4 {

	private static final double PI = 3.1415926535897932384626433;

	public static void show() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Input radius number: ");
				double r = Double.parseDouble(sc.nextLine());

				System.out.print("Input height number: ");
				double h = Double.parseDouble(sc.nextLine());

				double surfaceArea = 2 * PI * r * (r + h);
				double baseArea = 2 * PI * r * h;
				double volume = PI * r * 2 * h;

				System.out.println("Surface area = " + surfaceArea);
				System.out.println("Base area = " + baseArea);
				System.out.println("Volume = " + volume);

				sc.close();
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
				continue;
			}
		}
	}
}
