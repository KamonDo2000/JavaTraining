package view;

import java.util.Scanner;

public class InputAirport {
	private static Scanner sc = new Scanner(System.in);

	public static String inIDAirport() {
		return InputPlan.inputID("airport");
	}

	public static String inName() {
		System.out.print("Input name Air port: ");
		return sc.nextLine();
	}

	public static float inRunwaySize() {
		do {
			try {
				System.out.print("Input Runway size: ");
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.println("only input float value!!");
				continue;
			}
		} while (true);
	}

	public static int inMaxFixedParking() {
		do {
			try {
				System.out.print("Input Max Fixed Parking: ");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.println("only input int value!!");
				continue;
			}
		} while (true);
	}
	
	public static int inmaxRotatedParking() {
		do {
			try {
				System.out.print("Input Max Rotated Parking: ");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.println("only input int value!!");
				continue;
			}
		} while (true);
	}
}
