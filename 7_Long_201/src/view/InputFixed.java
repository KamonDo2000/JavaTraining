package view;

import java.util.Scanner;

public class InputFixed {
	private static Scanner sc = new Scanner(System.in);

	private static final String RG_TYPE = "^CAG|LGR|PRV$";

	public static String inputIDFixWing() {
		return InputPlan.inputID("fixed");
	}

	public static String inputtype() {

		do {
			System.out.println("Input type fixed wing airplane: ");
			String type = sc.nextLine();

			if (type.matches(RG_TYPE)) {
				return type;
			} else {
				System.err.println("Sorry input type are CAG (Cargo), LGR (Long range) and PRV (Private)");
				continue;
			}

		} while (true);

	}

	public static float inputRunwaySize() {
		do {
			try {
				System.out.print("Input Runway size fixedWing: ");
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.println("only input float value!!");
				continue;
			}
		} while (true);
	}

}
