package view;

import java.util.Scanner;

public class InputHelicopter {

	private static Scanner sc = new Scanner(System.in);
	
	public static String inputIDHeli() {
		return InputPlan.inputID("helicopter");
	}

	public static float inRange() {
		do {
			try {
				System.out.println("Input value Range: ");
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.println("Input float value: ");
				continue;
			}
		} while (true);
	}

}
